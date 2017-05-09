package chaper01.knight;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by diwu.sld on 2016/3/16.
 */
public class Minstrel implements MethodBeforeAdvice {

    public void before(Method method, Object[] args, Object target) throws Throwable {
        IKnight knight = (IKnight)target;

        String name = knight.getName();
        System.out.println(name + ":" + knight.embarkOnQuest().toString());
    }
}
