package baselib;

/**
 * Created by diwu.sld on 2016/5/31.
 */
public interface ILogger {
    void warning(final String content);
    void info(final String content);
    void error(final String error);
}
