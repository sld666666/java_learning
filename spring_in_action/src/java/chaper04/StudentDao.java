package chaper04;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by diwu.sld on 2016/3/24.
 */
public class StudentDao {

    private JdbcTemplate template;

    public JdbcTemplate getTemplate() {
        return template;
    }

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }


    List<StudentEntity> getAllStudent(){
        List<StudentEntity> studentEntities = new ArrayList<StudentEntity>();
        String sql = "SELECT * FROM testor.student";
        studentEntities = (List<StudentEntity>) template.query(sql, new BeanPropertyRowMapper(StudentEntity.class));
        return  studentEntities;
    }

    boolean update(StudentEntity student){
        boolean rtn = true;
        String sql = "UPDATE testor.student SET age=?, name=? where id=?";
        this.template.update(sql, student.getAge(), student.getName(), student.getId());
        return  rtn;
    }


    public static void main(String[] args){
        ClassPathResource resource = new ClassPathResource("beans/chaper03_bean.xml");
        BeanFactory factory = new GenericXmlApplicationContext(resource);

        StudentDao dao = (StudentDao)factory.getBean("studentDao");
        if(dao != null){
            List<StudentEntity> allStudents = dao.getAllStudent();

            assert(!allStudents.isEmpty());

            StudentEntity entity = allStudents.get(0);
            entity.setAge(new Long(108));
            dao.update(entity);
        }
    }
}
