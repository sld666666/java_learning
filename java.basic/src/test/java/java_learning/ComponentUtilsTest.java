package java_learning;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.framework.TestCase;

import java.util.List;

import contex.compoments.TitleCompment;
import contex.define.IRule;
import contex.utils.ComponentUtils;

/**
 * ComponentUtils Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>05/08/2017</pre>
 */
public class ComponentUtilsTest extends TestCase {
    public ComponentUtilsTest(String name) {
        super(name);
    }

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Method: getRules(@NonNull IComponent component)
     */
    public void testGetRules() throws Exception {
        TitleCompment compment = new TitleCompment();
        List<IRule> rules = ComponentUtils.getRules(compment);

        assertTrue(rules.size() >= 2);
 //TODO: Test goes here...
    }


    public static Test suite() {
        return new TestSuite(ComponentUtilsTest.class);
    }
} 
