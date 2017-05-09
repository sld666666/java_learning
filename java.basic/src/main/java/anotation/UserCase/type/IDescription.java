package anotation.UserCase.type;

import java.lang.annotation.*;

/**
 * Created by diwu.sld on 2016/5/18.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface IDescription {
    public String value() default "";
}
