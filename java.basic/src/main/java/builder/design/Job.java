package builder.design;

/**
 * Created by diwu.sld on 2017/3/28.
 */
public class Job {

    private  String name;
    private String group;

    public void setName(String name) {
        this.name = name;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void run(){
        System.out.println(this.name);
        System.out.println(this.group);
    }
}
