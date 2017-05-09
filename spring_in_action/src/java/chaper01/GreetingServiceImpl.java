package chaper01;

/**
 * Created by diwu.sld on 2016/3/16.
 */
public class GreetingServiceImpl implements GreetingService {

    private String greeting;

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public void sayHello() {
        System.out.println(this.greeting);
    }
}
