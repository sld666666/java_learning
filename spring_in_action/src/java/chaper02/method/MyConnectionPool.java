package chaper02.method;

/**
 * Created by diwu.sld on 2016/3/17.
 */
public class MyConnectionPool {


    public  void initialize(){
        System.out.println("MyConnectionPool:initialize");
    }

    public  void close(){
        System.out.println("MYConnectionPool::close");
    }

    public void done(){
        System.out.println("MyConnectionPool::done");
    }
}
