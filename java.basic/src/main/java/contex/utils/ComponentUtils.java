package contex.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import contex.anotation.AddRule;
import contex.define.IComponent;
import contex.define.IRule;
import contex.factory.RuleFactory;
import lombok.NonNull;

/**
 * Created by diwu.sld on 2017/5/8.
 */
public class ComponentUtils {
    private  ComponentUtils(){

    }

    public static List<IRule> getRules(@NonNull IComponent component){
        List<String> ruleNames = Arrays.asList(component.getClass().getAnnotation(AddRule.class).id());


        List<IRule> rtn = ruleNames.stream().map( ruleName -> RuleFactory.getInstance().getRule(ruleName))
                .collect(Collectors.toList());

        rtn.stream().forEach( item -> item.init());
        return  rtn;

    }
}
