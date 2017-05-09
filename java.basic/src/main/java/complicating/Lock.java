package complicating;

/**
 * Created by diwu.sld on 2016/9/19.
 */
public class Lock {
    private Object lock;

    public Lock() {
        lock = this;
    }

    public void write() {
        synchronized (lock)
        {
            long startTime = System.currentTimeMillis();
            System.out.println("开始往这个buff写入数据…");
            for (;;)// 模拟要处理很长时间
            {
                if (System.currentTimeMillis()
                        - startTime > 10000) {
                    break;
                }
            }
            System.out.println("终于写完了");
        }
    }

    public void read() {
        synchronized (lock)
        {
            System.out.println("从这个buff读数据");
        }
    }

    static public  void main(String[] args) {
        Lock lock = new Lock();
        StartThread startThread = new StartThread();
        startThread.setLock(lock);
        ReadThread readThread = new ReadThread();
        readThread.setLock(lock);
        startThread.start();
        readThread.start();
    }
}
