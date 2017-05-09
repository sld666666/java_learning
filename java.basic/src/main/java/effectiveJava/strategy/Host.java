package effectiveJava.strategy;

/**
 * Created by diwu.sld on 2017/4/11.
 */
public class Host {

    private static class StrlenCmp implements IComparator<String>{

        public int compare(String v1, String v2) {
            return v1.length() - v2.length();
        }
    }

    public  static final IComparator<String> strlenCmp = new StrlenCmp();
}
