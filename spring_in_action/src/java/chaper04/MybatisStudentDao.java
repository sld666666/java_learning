package chaper04;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

/**
 * Created by diwu.sld on 2016/3/25.
 */
public class MybatisStudentDao {

    public static void main(String[] args) throws IOException {
        ClassPathResource resource = new ClassPathResource("beans/mybatis-config.xml");
        SqlSessionFactory  sqlSessionFactory = new SqlSessionFactoryBuilder().build(resource.getInputStream());

        SqlSession session = sqlSessionFactory.openSession();

        try {

            /*
            StudentEntity student = (StudentEntity)session.selectOne("chaper04.selectStudent", 1);
            System.out.println(student.getName());
            */


            StudentMapper mapper =  session.getMapper(StudentMapper.class);
            StudentEntity student = mapper.selectStudent(new Long(1));
            System.out.println(student.getName());

        } finally {
            session.close();
        }

    }
}
