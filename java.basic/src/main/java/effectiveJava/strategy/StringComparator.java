package effectiveJava.strategy;

import java.util.Arrays;

/**
 * Created by diwu.sld on 2017/4/11.
 */
public class StringComparator implements IComparator<String> {
    public int compare(String v1, String v2) {
        return v1.length() - v2.length();
    }

}
