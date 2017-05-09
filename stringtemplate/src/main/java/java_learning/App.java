package java_learning;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

import org.antlr.stringtemplate.*;
import org.antlr.stringtemplate.language.*;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Map;
import java.util.Timer;

import java_learning.parser.CommonJsonParser;
import java_learning.parser.IEngine;

/**
 * Hello world!
 *
 */
public class App
{

    public void test(){
        StringTemplateGroup group =  new StringTemplateGroup("myGroup", "E:\\Tutorials", DefaultTemplateLexer.class);
        StringTemplate helloAgain = group.getInstanceOf("homepage");

        helloAgain.setAttribute("title", "Welcome To StringTemplate");
        helloAgain.setAttribute("name", "World");
        helloAgain.setAttribute("friends", "Ter");
        helloAgain.setAttribute("friends", "Kunle");
        helloAgain.setAttribute("friends", "Micheal");
        helloAgain.setAttribute("friends", "Marq");

        System.out.println(helloAgain.toString());
    }

    public  String createConstant(CreateConstanConfig createConstanConfig ){
        StringTemplateGroup group =  new StringTemplateGroup("myGroup", "E:\\Tutorials", DefaultTemplateLexer.class);
        StringTemplate helloAgain = group.getInstanceOf("constant");
        Map<String, Object> configMap = JacksonUtil.objectToMap(createConstanConfig);

        configMap.entrySet().stream().forEach(value ->{
            String name = value.getKey();
            helloAgain.setAttribute(name, value.getValue());
        });

        return helloAgain.toString();
    }

    public static void main( String[] args )
    {
        IEngine engine = new CommonJsonParser();
        ObjectNode objectNode = JsonNodeFactory.instance.objectNode();
        objectNode.put("appName", "virtual");
        objectNode.put("appClassName", "Virtual");
        objectNode.put("date", "2017/01/18");
        objectNode.put("desc", "it is a virtual");
        objectNode.put("identity", "virtual-item-100");
        engine.parser("forlderConfig", objectNode);
        /*
        App app = new App();

        CreateConstanConfig constanConfig = new CreateConstanConfig();
        constanConfig.setPackageIdentiry("virtual");
        constanConfig.setDate("2017/1/16");
        constanConfig.setDesc("this is vitrual ");
        constanConfig.setClassIdentiry("Vitual");
        String rtn = app.createConstant(constanConfig);
        System.out.print(rtn);

        CreateAppService createAppService = new CreateAppService();
        createAppService.createAppProject(null);
        */
    }
}
