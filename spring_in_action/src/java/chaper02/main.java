package chaper02;

import chaper02.method.MyConnectionPool;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by diwu.sld on 2016/3/17.
 */
public class main {

    private static  BeanFactory factory;

    static {
        ClassPathResource resource = new ClassPathResource("beans/student_bean.xml");
        System.out.println(resource.getPath());
        factory = new GenericXmlApplicationContext(resource);
    }

    public  void test_01(){
        MyConnectionPool pool = (MyConnectionPool)factory.getBean("myConnectionPool");
        pool.done();
    }

    public  static void main(String [] args){

        main main_0 = new main();
        main_0.test_01();
    }
}
