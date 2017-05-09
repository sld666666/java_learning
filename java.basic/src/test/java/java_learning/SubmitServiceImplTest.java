package java_learning;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.framework.TestCase;

import java.util.HashMap;
import java.util.Map;

import contex.define.IComponentModel;
import contex.model.TitleModel;
import contex.service.ISubmitService;
import contex.service.impl.SubmitServiceImpl;

/**
 * SubmitServiceImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>05/09/2017</pre>
 */
public class SubmitServiceImplTest extends TestCase {
    ISubmitService submitService;
    public SubmitServiceImplTest(String name) {
        super(name);
    }

    public void setUp() throws Exception {
        submitService = new SubmitServiceImpl();
        super.setUp();
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Method: submit(Map<String, IComponentModel> entity)
     */
    public void testSubmit() throws Exception {
//TODO: Test goes here...
        Map<String, IComponentModel> entity = new HashMap<>();
        TitleModel model = new TitleModel();
        model.setTitle("aaabbb");
        entity.put("title", model);
        submitService.submit(entity);
    }


    /**
     * Method: excuteRules(IComponent component)
     */
    public void testExcuteRules() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = SubmitServiceImpl.getClass().getMethod("excuteRules", IComponent.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }


    public static Test suite() {
        return new TestSuite(SubmitServiceImplTest.class);
    }
} 
