package contex.define;

import java.util.List;

/**
 * Created by diwu.sld on 2017/5/4.
 */

public interface IComponent <T extends IComponentModel> {

    T getModel();

    void setModel(T value);
}
