package anotation.UserCase.type;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by diwu.sld on 2016/5/18.
 */
public class AnalysisAnnotation {

    public static void main(String [] args){
        try {
            Class rtnClass = Class.forName("anotation.UserCase.type.Utility");
            Annotation[] anotations =  rtnClass.getAnnotations();
            for (int i = 0; i < anotations.length; ++i){
                Annotation anotation = anotations[i];
                if(anotation.annotationType() == IDescription.class){
                    System.out.println(anotations[i].toString());

                    Method[] methods = rtnClass.getDeclaredMethods();
                    for (Method method : methods){
                        String rtn = (String) method.invoke(rtnClass.newInstance());
                        System.out.println(rtn);
                    }
                }
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
