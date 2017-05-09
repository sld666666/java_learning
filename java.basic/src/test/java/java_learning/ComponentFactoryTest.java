package java_learning;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import contex.define.IComponent;
import contex.define.IComponentModel;
import contex.factory.ComponentFactory;
import contex.model.TitleModel;

/**
 * ComponentFactory Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>05/08/2017</pre>
 */
public class ComponentFactoryTest extends TestCase {

    ComponentFactory componentFactory = new ComponentFactory();

    public ComponentFactoryTest(String name) {
        super(name);
    }

    public void setUp() throws Exception {
        super.setUp();
        componentFactory.init();
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Method: init()
     */
    public void testInit() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: loadComponents(List<String> ids)
     */
    public void testLoadComponents() throws Exception {
//TODO: Test goes here...
        List<String> ids = Arrays.asList("title");
        List<IComponent> components = this.componentFactory.loadComponents(ids);

        assertTrue(components.size() == 1);


        assertTrue( this.componentFactory.loadComponents(Arrays.asList("aabbcc")).size() == 0);
    }


    public void testLoadComponentsWithModel() throws  Exception{
        Map<String, IComponentModel> valueModel = new HashMap<>();
        TitleModel titleModel = new TitleModel();
        titleModel.setTitle("aabbcc");
        valueModel.put("title", titleModel);

        this.componentFactory.loadComponentsWithModel(valueModel);
    }

    public static Test suite() {
        return new TestSuite(ComponentFactoryTest.class);
    }
} 
