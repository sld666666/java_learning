package chaper02.students;

import java.util.Set;

/**
 * Created by diwu.sld on 2016/3/17.
 */
public interface StudentDao {

    public Student findById(String id);
    public void create(Student student);
    public Set getComplatedCourses(Student student);
}
