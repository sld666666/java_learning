package chaper02.students;

/**
 * Created by diwu.sld on 2016/3/17.
 */
public interface CourseDao {

    public Courser findById(String id);
    public void create(Courser course);
    
}
