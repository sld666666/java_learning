package contex.define;

/**
 * Created by diwu.sld on 2017/5/4.
 */
public abstract class AbstractRule <T> implements IRule {
    private  T model;

    public T getModel() {
        return this.model;
    }

    protected  void setModel(T model){
        this.model = model;
    }


}
