package chaper02.students;

import java.util.Set;

/**
 * Created by diwu.sld on 2016/3/17.
 */
public class StudentDaoImpl implements StudentDao {
    public Student findById(String id) {
        System.out.print("StudentDaoImpl::findById");
        return null;
    }

    public void create(Student student) {
        System.out.print("StudentDaoImpl::create");
    }

    public Set getComplatedCourses(Student student) {
        System.out.print("StudentDaoImpl::getComplatedCourses");
        return null;
    }
}
