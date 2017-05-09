package anotation.UserCase.type;

import java.lang.annotation.*;

/**
 * Created by diwu.sld on 2016/5/18.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface IAuthor {
    String name();
    String group();
}
