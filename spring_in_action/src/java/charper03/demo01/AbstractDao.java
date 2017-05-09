package charper03.demo01;

/**
 * Created by diwu.sld on 2016/3/24.
 */
public abstract class AbstractDao {

    private Transaction transaction = new Transaction();

    public void  excute(){
        transaction.begin();
        doExcute();
        transaction.end();
    }

     public  abstract void doExcute();
}
