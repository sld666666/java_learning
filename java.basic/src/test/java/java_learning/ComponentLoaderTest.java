package java_learning;

import junit.framework.Test; 
import junit.framework.TestSuite; 
import junit.framework.TestCase;

import java.util.Map;

import contex.define.IComponent;
import contex.utils.ComponentLoaderUtil;

/** 
* ComponentLoader Tester. 
* 
* @author <Authors name> 
* @since <pre>05/05/2017</pre> 
* @version 1.0 
*/ 
public class ComponentLoaderTest extends TestCase { 
public ComponentLoaderTest(String name) { 
super(name); 
} 

public void setUp() throws Exception { 
super.setUp(); 
} 

public void tearDown() throws Exception { 
super.tearDown(); 
} 

/** 
* 
* Method: loadAllComponnets() 
* 
*/ 
public void testLoadAllComponnets() throws Exception { 
//TODO: Test goes here...
    Map<String, IComponent>  result = ComponentLoaderUtil.loadAllComponnets();

    assertTrue(result.size() > 0);
} 



public static Test suite() { 
return new TestSuite(ComponentLoaderTest.class); 
} 
} 
