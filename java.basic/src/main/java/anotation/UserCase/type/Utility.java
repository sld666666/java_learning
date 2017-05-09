package anotation.UserCase.type;

/**
 * Created by diwu.sld on 2016/5/18.
 */

@IDescription(value = "Utility")
public class Utility {
    @IAuthor(name="sld", group = "taobao")
    public String work(){
        return "work over!";
    }
}
