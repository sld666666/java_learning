package effectiveJava.strategy;

/**
 * Created by diwu.sld on 2017/4/11.
 */
public interface IComparator<T> {

    public int compare(T v1, T v2);
}
