package anotation.UserCase;

/**
 * Created by diwu.sld on 2016/5/17.
 */
public @interface Table {

    public String tableName() default "defualt name";
}
