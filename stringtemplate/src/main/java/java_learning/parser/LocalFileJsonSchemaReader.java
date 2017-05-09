package java_learning.parser;

import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;

/**
 * Created by diwu.sld on 2017/1/17.
 */
public class LocalFileJsonSchemaReader implements IJsonSchemaReader{
    JsonSchemaFactory factory = new JsonSchemaFactory();
    IReader reader = new LocalFileReader();

    @Override
    public JsonSchema getJsonSchema(String key) {
        String content = reader.get(key);
        if (null != content){
            try {
                JsonSchema schema  = getJsonSchemaFromStringContent(content);
                return schema;
            }catch (Exception e){
                int i = 0;
            }
        }
        return null;
    }

    private JsonSchema getJsonSchemaFromStringContent(String schemaContent) throws Exception {
        JsonSchema schema = this.factory.getSchema(schemaContent);
        return schema;
    }

}
