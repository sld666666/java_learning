package java_learning;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.ValidationMessage;

import org.antlr.stringtemplate.StringTemplate;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Set;

import java_learning.parser.IJsonSchemaReader;
import java_learning.parser.IReader;
import java_learning.parser.LocalFileJsonSchemaReader;
import java_learning.parser.LocalFileReader;

/**
 * Created by diwu.sld on 2017/1/18.
 */
public class AppCreator {
    private final String ST_FORMAT = "st/%s.st";
    private final String SCHEMA_FORMAT = "jsonschema/%s.json";

    private IReader read = new LocalFileReader();

    private IJsonSchemaReader schemaReader = new LocalFileJsonSchemaReader();

    public Boolean doCreateFile(String fileName, String template, ObjectNode config, List<String> parents){
        Boolean rtn = true;
        String path = listToPath(parents) + fileName;

        try {
            Path file = Paths.get(path);
            String content = getReverserValue(template, config);
            Files.write(file, content.getBytes(Charset.forName("UTF-8")));
        } catch (IOException e) {
            e.printStackTrace();
            rtn = false;
        }
        return  rtn;
    }

    public Boolean doCreateFolder(String folderName, List<String> parents){
        Boolean rtn = true;
        String path = listToPath(parents) + folderName;

        File file = new File(path);
        if (!file.exists()){
            file.mkdir();
        }

        return  rtn;
    }

    public String listToPath(List<String> contents){
        String rtn = contents.stream().reduce("", (tmp, content) -> {
            tmp += content;
            tmp += File.separator;
            return  tmp;
        });
        return  rtn;
    }

    public   String getReverserValue(String key, ObjectNode config){
        String schemaName = String.format(SCHEMA_FORMAT, key);
        String configName = String.format(ST_FORMAT, key);

        String templateValue = this.read.get(configName);
        if (!vilidateSchema(schemaName, config)){
            return null;
        }

        StringTemplate stringTemplate = new StringTemplate(templateValue);

        Map<String, Object> configMap = JacksonUtil.objectToMap(config);
        configMap.entrySet().stream().forEach(value ->{
            String name = value.getKey();
            stringTemplate.setAttribute(name, value.getValue());
        });

        return  stringTemplate.toString();
    }

    private  Boolean vilidateSchema(String schemaName, ObjectNode config){
        JsonSchema jsonSchema = schemaReader.getJsonSchema(schemaName);
        if (null != jsonSchema) {
            Set<ValidationMessage> errors = jsonSchema.validate(config);
            if (errors.size() != 0) {
                return false;
            }
        }

        return true;
    }
}
