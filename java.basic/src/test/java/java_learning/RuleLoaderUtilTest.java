package java_learning;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.framework.TestCase;

import java.util.Map;

import contex.define.IRule;
import contex.utils.RuleLoaderUtil;

/**
 * RuleLoaderUtil Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>05/08/2017</pre>
 */
public class RuleLoaderUtilTest extends TestCase {
    public RuleLoaderUtilTest(String name) {
        super(name);
    }

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Method: loadRules()
     */
    public void testLoadRules() throws Exception {
//TODO: Test goes here...
        Map<String, IRule> rules = RuleLoaderUtil.loadRules();
        assertTrue(rules.size() > 0);
    }


    public static Test suite() {
        return new TestSuite(RuleLoaderUtilTest.class);
    }
} 
