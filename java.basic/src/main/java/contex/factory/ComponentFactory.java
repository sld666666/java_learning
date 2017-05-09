package contex.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import contex.anotation.Comp;
import contex.define.IComponent;
import contex.define.IComponentModel;
import contex.utils.ComponentLoaderUtil;


/**
 * Created by diwu.sld on 2017/5/4.
 */
public final class ComponentFactory {

    private Map<String, IComponent>  componentMap;


    public void init(){

        this.componentMap = ComponentLoaderUtil.loadAllComponnets();
    }

    public List<IComponent> loadComponents(List<String> ids){

        List<IComponent> rtn = new ArrayList<>();

        rtn = ids.stream().
                filter(id ->{
                    return  this.componentMap.containsKey(id);
                }).
                map(id -> {
                    return  this.componentMap.get(id);
                }).collect(Collectors.toList());

        return  rtn;
    }

    public List<IComponent> loadComponentsWithModel(Map<String, IComponentModel> valueModel){

        List<IComponent> components = this.loadComponents(new ArrayList<>(valueModel.keySet()));
        components.stream().forEach(component -> {
            String id = component.getClass().getAnnotation(Comp.class).id();
            loadComponentsValue(component, valueModel.get(id));
        });

        return  components;
    }

    private void loadComponentsValue(IComponent component, IComponentModel value){
        component.setModel(value);
    }

}
