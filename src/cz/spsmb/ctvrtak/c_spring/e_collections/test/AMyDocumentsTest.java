/**
 * 
 */
package cz.spsmb.ctvrtak.c_spring.e_collections.test;


import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import cz.spsmb.ctvrtak.c_spring.a_config.main.java.Doc;
import cz.spsmb.ctvrtak.c_spring.a_config.main.java.Type;
import cz.spsmb.ctvrtak.c_spring.a_config.main.java.SearchEngine;

/**
 * @author Felipe Gutierrez
 *
 */
public class AMyDocumentsTest {

	private ClassPathXmlApplicationContext context;
	private SearchEngine engine;
	private Type webType;
	
	@BeforeEach
	public void setup(){
		//System.setProperty(org.slf4j.simple.SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "Debug");
		context = new ClassPathXmlApplicationContext("mydocuments-context.xml");
	}
	
	@Test
	public void testAll() {	
		engine = context.getBean(SearchEngine.class);
		webType = context.getBean("webType",Type.class);
		
		List<Doc> documents = engine.findByType(webType);
		Assertions.assertNotNull(documents);
		Assertions.assertTrue(documents.size() == 1);
		Assertions.assertEquals(webType.getName(),documents.get(0).getType().getName());
		Assertions.assertEquals(webType.getDesc(),documents.get(0).getType().getDesc());
		Assertions.assertEquals(webType.getExtension(),documents.get(0).getType().getExtension());
		
		engine = context.getBean(SearchEngine.class);
		
		documents = engine.listAll();
		Assertions.assertNotNull(documents);
		Assertions.assertTrue(documents.size() == 4);
	}
}
