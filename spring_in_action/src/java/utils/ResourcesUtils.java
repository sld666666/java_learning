package utils;


import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;

/**
 * Created by diwu.sld on 2016/2/29.
 */
public class ResourcesUtils {
    private Logger log = LoggerFactory.getLogger(ResourcesUtils.class);
    public URL getResourceUri(String path){
        URL uri = ResourcesUtils.class.getClassLoader().getResource(path);
        return uri;
    }

    public String getContent(String path) throws IOException {
        URL uri = getResourceUri(path);;
        String content = Resources.toString(uri, Charsets.UTF_8);
        return content;
    }
}
