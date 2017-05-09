package builder.design;

/**
 * Created by diwu.sld on 2017/3/28.
 */
public class JobBuilder {
    private String name;
    private String group;


    protected JobBuilder(){

    }

    public static JobBuilder newJob(){
        return  new JobBuilder();
    }

    public  JobBuilder setName(String name){
        this.name = name;
        return  this;
    }

    public JobBuilder setGroup(String group){
        this.group = group;
        return  this;
    }

    public Job builder(){
        Job job = new Job();
        job.setGroup(this.group);
        job.setName(this.name);

        return  job;
    }

    public  static  void main(String [] args){
        Job job = JobBuilder.newJob()
                .setName("name_abc")
                .setGroup("group1")
                .builder();
        job.run();
    }
}
