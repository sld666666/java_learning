package contex.compoments;

import contex.anotation.AddRule;
import contex.anotation.Comp;
import contex.define.AbstractComponent;
import contex.model.TitleModel;

/**
 * Created by diwu.sld on 2017/5/4.
 */
@Comp(id = "title")
@AddRule(id= {"maxLengthRule", "requiredRule"})
public class TitleCompment extends AbstractComponent<TitleModel> {
}
