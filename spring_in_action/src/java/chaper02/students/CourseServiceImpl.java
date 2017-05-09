package chaper02.students;

import java.util.Set;

/**
 * Created by diwu.sld on 2016/3/17.
 */
public class CourseServiceImpl implements  CourseService{
    private CourseDao courseDao;
    private StudentService studentService;
    private  int maxStudents;

    public CourseServiceImpl() {
    }

    public CourseDao getCourseDao() {
        return courseDao;
    }

    public void setCourseDao(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    public StudentService getStudentService() {
        return studentService;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public int getMaxStudents() {
        return maxStudents;
    }

    public void setMaxStudents(int maxStudents) {
        this.maxStudents = maxStudents;
    }

    public Courser getCourse(String id) {
        return this.courseDao.findById(id);
    }

    public void createCourse(Courser course) {
        this.courseDao.create(course);
    }

    public Set getAllCourses() {
        return null;
    }

    public void enrollStudentInCourse(Courser course, Student student) {

    }
}
