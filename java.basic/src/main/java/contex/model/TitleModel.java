package contex.model;

import contex.define.AbstractModel;
import contex.define.IComponentModel;

/**
 * Created by diwu.sld on 2017/5/4.
 */
public class TitleModel implements IComponentModel{

    private  String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
