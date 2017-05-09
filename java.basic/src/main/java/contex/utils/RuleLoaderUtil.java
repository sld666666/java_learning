package contex.utils;

import org.reflections.Reflections;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import contex.anotation.Rule;
import contex.define.IRule;

/**
 * Created by diwu.sld on 2017/5/8.
 */
public class RuleLoaderUtil {
    private RuleLoaderUtil(){

    }

    public static Map<String, IRule> loadRules(){
        Reflections reflections = new Reflections("contex.rules");
        Set<Class<?>> annotateds = reflections.getTypesAnnotatedWith(Rule.class);
        return annotateds.stream().collect(
                Collectors.toMap(annotated -> annotated.getAnnotation(Rule.class).id(),
                        annotated-> {
                            return InstanceUtils.createInstance(annotated);
                }));
    }
}
