package java_learning.parser;

import com.networknt.schema.JsonSchema;

/**
 * Created by diwu.sld on 2017/1/17.
 */
public interface IJsonSchemaReader {

    public JsonSchema getJsonSchema(String key);
}
