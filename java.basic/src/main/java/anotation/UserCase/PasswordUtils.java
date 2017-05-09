package anotation.UserCase;

/**
 * Created by diwu.sld on 2016/5/16.
 */
public class PasswordUtils {

    @IUserCase(id=1)
    public boolean validatePasswrod(final String password){
        return true;
    }

    @IUserCase(id=2, description = "encryptPassword")
    public String encryptPassword(final String password){
        return  "aaaa" + password;
    }
}
