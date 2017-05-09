package contex.factory;

import java.util.Map;

import contex.define.IRule;
import contex.utils.RuleLoaderUtil;

/**
 * Created by diwu.sld on 2017/5/8.
 */
public  final class RuleFactory {

    private static RuleFactory instance;

    private  static Map<String, IRule> nameAndRules;

    private RuleFactory(){

    }

    public static synchronized RuleFactory getInstance(){

        if ( null == instance){
            instance = new RuleFactory();
            instance.init();
        }

        return  instance;
    }

    public void init(){
        this.nameAndRules = RuleLoaderUtil.loadRules();
    }


    public IRule getRule(final  String ruleName){
        return  this.nameAndRules.get(ruleName);
    }
}
