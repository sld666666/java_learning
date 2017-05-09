package java_learning.parser;

import com.fasterxml.jackson.databind.node.ObjectNode;


/**
 * Created by diwu.sld on 2017/1/17.
 */
public interface IEngine {

    Boolean parser(String configName, ObjectNode config);
}
