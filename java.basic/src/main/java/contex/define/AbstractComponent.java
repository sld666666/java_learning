package contex.define;

/**
 * Created by diwu.sld on 2017/5/5.
 */
public abstract class AbstractComponent <T extends  IComponentModel>
        implements  IComponent<T>{
    private T model;

    @Override
    public T getModel() {
        return this.model;
    }


    @Override
    public void setModel(T value){
        this.model = value;
    }

}
