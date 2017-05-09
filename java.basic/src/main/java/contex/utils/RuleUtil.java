package contex.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import contex.Contex;
import contex.anotation.Param;
import contex.anotation.RuleValidate;
import contex.define.IRule;
import lombok.NonNull;

/**
 * Created by diwu.sld on 2017/5/8.
 */
public final class RuleUtil {
    private RuleUtil(){

    }

    public static Method getValidateMethod(@NonNull IRule rule){
        Method[]  methods = rule.getClass().getMethods();
        try {
            Method rtn = Stream.of(methods).filter(method -> {
                return  (method.getAnnotation(RuleValidate.class) != null);
            }).findFirst().get();
            return rtn;
        }catch (Exception e){
            return  null;
        }
    }

    public static  boolean excute(@NonNull Method method, @NonNull IRule rule, @NonNull Contex contex){
        boolean rtn = false;
        try {
            Annotation[][]  annotations = method.getParameterAnnotations();

            List<Object> args = new ArrayList();
            for (int i = 0; i < annotations.length; ++i){

                Annotation annotation = annotations[i][0];
                String annotationName = annotation.annotationType().getName();
                if (Param.class.getName().equals(annotationName)){
                    Param param = (Param)annotation;
                    args.add(contex.getEntity().get(param.value()));
                }
            }

            rtn = (boolean) method.invoke(rule, args.toArray());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return rtn;
    }


}
