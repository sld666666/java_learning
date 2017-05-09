package java_learning.parser;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

import java_learning.AppCreator;
import java_learning.JacksonUtil;


/**
 * Created by diwu.sld on 2017/1/17.
 */
public class CommonJsonParser implements IEngine {

    private IReader read = new LocalFileReader();

    private AppCreator  appCreator = new AppCreator();

    public Boolean parser(String configName, ObjectNode config)
    {
        Boolean rtn = true;
        String content = this.appCreator.getReverserValue(configName, config);

        try {
            ObjectNode configObj = (ObjectNode) JacksonUtil.stringToObject(content);
            List<String> parents = new ArrayList<>();
            rtn = doCreate(config,configObj, parents);

        } catch (IOException e) {
           // e.printStackTrace();
            //log.errror();
            int i = 0;
        }

        return  rtn;

    }


    private Boolean doCreate(ObjectNode appConfig, ObjectNode forlderConfig, List<String> parents){
        Boolean rtn = true;

        String type  = "folder";
        if (forlderConfig.has("type"))
            type = forlderConfig.get("type").asText();

        String name =forlderConfig.get("name").asText();

        if ("file".equals(type)){
            String template = forlderConfig.get("template").asText();
            rtn =  rtn & this.appCreator.doCreateFile(name, template, appConfig, parents);
        }else{
            rtn = rtn & this.appCreator.doCreateFolder(name, parents);

            if (forlderConfig.has("children")){
                ArrayNode children = (ArrayNode)forlderConfig.get("children");
                StreamSupport.stream(children.spliterator(), false).forEach( jsonNode -> {
                    List<String> tmpParents = new ArrayList<String>(parents);
                    tmpParents.add(name);
                    doCreate(appConfig, (ObjectNode)jsonNode, tmpParents);
                });
            }
        }


        return rtn;
    }


}
