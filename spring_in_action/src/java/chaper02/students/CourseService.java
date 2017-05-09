package chaper02.students;

import java.util.Set;

/**
 * Created by diwu.sld on 2016/3/17.
 */
public interface CourseService {

    public  Courser getCourse(String id);
    public void createCourse(Courser course);
    public Set getAllCourses();
    public void enrollStudentInCourse(Courser course, Student student);
}
