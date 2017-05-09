package chaper02.students;

import java.util.Set;

/**
 * Created by diwu.sld on 2016/3/17.
 */
public class StudentsServiceImpl implements StudentService {
    private StudentDao studentDao;

    public StudentsServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public StudentDao getStudentDao() {
        return studentDao;
    }

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public Student getStudent(String id) {
        return this.studentDao.findById(id);
    }

    public void createStudent(Student student) {
        this.studentDao.create(student);
    }

    public Set getCompletedCourses(Student student) {
        return this.getCompletedCourses(student);
    }
}
