package contex.rules;

import contex.Contex;
import contex.anotation.Rule;
import contex.define.AbstractRule;
import contex.define.IRule;
import contex.model.RequireRuleModel;

/**
 * Created by diwu.sld on 2017/5/4.
 */

@Rule(id = "requiredRule")
public class RequiredRule extends AbstractRule<RequireRuleModel> {

    public void init(){
        RequireRuleModel model = new  RequireRuleModel();
        this.setModel(model);
    }

    public boolean validate(Contex contex) {
        return false;
    }

}
