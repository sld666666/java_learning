package chaper02.students;

import java.util.Set;

/**
 * Created by diwu.sld on 2016/3/17.
 */
public interface StudentService {

    public  Student getStudent(String id);
    public  void createStudent(Student student);
    public Set getCompletedCourses(Student student);
}
