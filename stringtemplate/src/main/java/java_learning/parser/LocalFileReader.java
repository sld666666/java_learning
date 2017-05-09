package java_learning.parser;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;

import java.io.IOException;
import java.net.URL;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by diwu.sld on 2017/1/17.
 */

@Slf4j
public class LocalFileReader implements  IReader {

    public String get(String key) {
        URL uri = LocalFileReader.class.getClassLoader().getResource(key);
        String content = null;
        if (null != uri){
            try {
                content = Resources.toString(uri, Charsets.UTF_8);
            } catch (IOException e) {
                //log.error()
            }
        }
        return  content;
    }
}
