package builder.normal;

/**
 * Created by diwu.sld on 2017/3/28.
 */
public class Job{
    private String name;
    private String group;

    public void setName(final String name){
        this.name = name;
    }

    public  void setGroup(final String group){
        this.group = group;
    }

    public void run(){
        System.out.println(this.name);
        System.out.println(this.group);
    }


    public  static void main(String [] args){
        Job job = new Job();
        job.setName("name_abc");
        job.setGroup("group1");
        job.run();
    }
}
