package contex.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import contex.Contex;
import contex.anotation.RuleValidate;
import contex.define.IComponent;
import contex.define.IComponentModel;
import contex.define.IRule;
import contex.factory.ComponentFactory;
import contex.service.ISubmitService;
import contex.utils.ComponentUtils;
import contex.utils.RuleUtil;

/**
 * Created by diwu.sld on 2017/5/8.
 */
public class SubmitServiceImpl implements ISubmitService {

    private ComponentFactory componentFactory = new ComponentFactory();

    public SubmitServiceImpl(){
        componentFactory.init();
    }
    @Override
    public boolean submit(Map<String, IComponentModel> entity) {
        List<IComponent> components = this.componentFactory.loadComponentsWithModel(entity);

        Contex contex = new Contex();
        contex.setEntity(entity);
        components.stream().forEach(component -> excuteRules(component, contex));

        return true;
    }

    private boolean excuteRules(IComponent component, Contex contex){

        List<IRule> rules = ComponentUtils.getRules(component);

        boolean result = rules.stream().allMatch( rule -> {
            Method method = RuleUtil.getValidateMethod(rule);
            return (null == method)? false: RuleUtil.excute(method,rule, contex);
        });

        rules.getClass().getAnnotation(RuleValidate.class);
        return  result;
    }
}
