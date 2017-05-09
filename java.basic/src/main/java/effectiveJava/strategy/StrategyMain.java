package effectiveJava.strategy;

/**
 * Created by diwu.sld on 2017/4/11.
 */
public class StrategyMain {

    public  static  int compare(String v1, String v2, IComparator c){
        return  c.compare(v1, v2);
    }

    public  static  void main(String [] args){
        System.out.println(StrategyMain.compare("aaa", "aaaa", new StringComparator()));

        System.out.println(StrategyMain.compare("aaa", "aaaa", Host.strlenCmp));
    }
}
