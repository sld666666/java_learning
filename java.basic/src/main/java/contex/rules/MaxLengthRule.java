package contex.rules;

import contex.Contex;
import contex.anotation.Param;
import contex.anotation.Rule;
import contex.anotation.RuleValidate;
import contex.define.AbstractRule;
import contex.model.MaxLengthRuleModel;
import contex.model.TitleModel;

/**
 * Created by diwu.sld on 2017/5/4.
 */

@Rule( id = "maxLengthRule")
public class MaxLengthRule  extends AbstractRule<MaxLengthRuleModel> {
    public void init() {
        MaxLengthRuleModel model = new MaxLengthRuleModel();
        model.setMaxLength(100L);
        this.setModel(model);
    }

    @RuleValidate(id = "RuleValidate")
    public boolean validate(@Param("title") TitleModel titleModel,
                            @Param("subTitle") TitleModel subTitleModel) {
        return titleModel.getTitle().length() < getModel().getMaxLength();
    }
}
