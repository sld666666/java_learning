package java_learning.knight;

import chaper01.knight.HolyGrail;
import chaper01.knight.KnightOfRoundTable;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import static junit.framework.TestCase.assertNotNull;

/** 
* HolyGrailQuest Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 16, 2016</pre> 
* @version 1.0 
*/ 
public class HolyGrailQuestTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: embark() 
* 
*/ 
@Test
public void testEmbark() throws Exception { 
//TODO: Test goes here...
    KnightOfRoundTable knight = new KnightOfRoundTable("John");
    HolyGrail holyGrail = knight.embarkOnQuest();

    assertNotNull(holyGrail);
} 


} 
