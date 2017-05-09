package complicating;

/**
 * Created by diwu.sld on 2016/9/19.
 */
public class ReadThread extends  Thread {

    private Lock lock;

    public Lock getLock() {
        return lock;
    }

    public void setLock(Lock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        lock.read();
    }
}
