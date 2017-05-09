package chaper01;

import chaper01.knight.HolyGrail;
import chaper01.knight.IKnight;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * Created by diwu.sld on 2016/3/16.
 */
public class main {

    public  void test_01(){

        ClassPathResource resource = new ClassPathResource("beans/beans.xml");
        System.out.println(resource.getPath());
        BeanFactory factory = new GenericXmlApplicationContext(resource);
        GreetingService greeting = (GreetingService) factory.getBean("greetService");
        greeting.sayHello();
    }

    public  void test_02(){
        ClassPathResource resource = new ClassPathResource("beans/beans.xml");
        System.out.println(resource.getPath());
        BeanFactory factory = new GenericXmlApplicationContext(resource);
        IKnight knight = (IKnight) factory.getBean("knight");
        HolyGrail holyGrail = knight.embarkOnQuest();
        System.out.println(holyGrail.toString());
    }

    public static  void main(String [] args) {
        main main_ = new main();
        main_.test_02();
    }
}
