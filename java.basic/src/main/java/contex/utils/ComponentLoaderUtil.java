package contex.utils;

import org.reflections.Reflections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import contex.anotation.Comp;
import contex.define.IComponent;
import java.util.stream.Collectors;

/**
 * Created by diwu.sld on 2017/5/4.
 */
public class ComponentLoaderUtil {

    private ComponentLoaderUtil(){

    }

    public static Map<String, IComponent>  loadAllComponnets(){
        Reflections reflections = new Reflections("contex.compoments");
        Set<Class<?>> annotateds = reflections.getTypesAnnotatedWith(Comp.class);

        return annotateds.stream().collect(
                Collectors.toMap(annotated -> annotated.getAnnotation(Comp.class).id(),
                annotated-> {
                    return InstanceUtils.createInstance(annotated);
                }));
    }



}
