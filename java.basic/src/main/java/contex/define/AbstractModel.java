package contex.define;


/**
 * Created by diwu.sld on 2017/5/4.
 */


public abstract class AbstractModel <T>  implements IComponentModel{
    private  T model;

    public void setModel(T model) {
        this.model = model;
    }

    public  T getModel(){
        return  this.model;
    }
}
