package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

/**
 * Created by diwu.sld on 2016/8/5.
 */
public class ExecutorServiceDemo {
    static final private int MaxThreadSize = 10;


    private void excute() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(MaxThreadSize);
        for (int i = 0; i < 10; ++i){
            executor.execute(new Runnable() {

                public void run() {
                    try {
                        System.out.println("done");
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            });
        }
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.DAYS);
    }

    static  public void main(String [] args) throws InterruptedException {
        ExecutorServiceDemo executorServiceDemo = new ExecutorServiceDemo();
        executorServiceDemo.excute();
        executorServiceDemo.excute();
    }
}
