package anotation.UserCase;

import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by diwu.sld on 2016/5/17.
 */
public class UserCaseTracker {

    public  void trackUsecase(Class<?>cl){
        for (Method method : cl.getDeclaredMethods()){
            IUserCase uc = method.getAnnotation(IUserCase.class);
            if(uc != null){
                System.out.println(uc.id() + " : " + uc.description());
            }
        }
    }

    public static void main(String [] args){
        UserCaseTracker tracker = new UserCaseTracker();
        tracker.trackUsecase(PasswordUtils.class);
    }
}
