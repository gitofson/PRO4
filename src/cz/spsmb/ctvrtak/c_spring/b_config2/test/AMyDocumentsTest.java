/**
 * 
 */
package cz.spsmb.ctvrtak.c_spring.b_config2.test;

import java.util.List;


import cz.spsmb.ctvrtak.c_spring.a_config.main.java.Doc;
import cz.spsmb.ctvrtak.c_spring.a_config.main.java.SearchEngine;
import cz.spsmb.ctvrtak.c_spring.a_config.main.java.Type;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * @author Felipe Gutierrez
 * Spring XML konfigurace
 * 		- Dobře čitelné, můžeme rozšiřovat, lze pro přehlednost i rozdělit do vícero souborů.
 *
 */
public class AMyDocumentsTest {

	private ClassPathXmlApplicationContext context;
	private SearchEngine engine;
	private Type webType;

	@BeforeEach
	public void setup(){
		context = new ClassPathXmlApplicationContext("mydocuments-context.xml");
		engine = context.getBean("engine", SearchEngine.class);
		webType = context.getBean("testWebType",Type.class);
	}
	
	@Test
	public void testWithSpringFindByType() {	
		List<Doc> documents = engine.findByType(webType);
		Assertions.assertNotNull(documents);
		Assertions.assertEquals(1, documents.size());
		Assertions.assertEquals(webType.getName(),documents.get(0).getType().getName());
		Assertions.assertEquals(webType.getDesc(),documents.get(0).getType().getDesc());
		Assertions.assertEquals(webType.getExtension(),documents.get(0).getType().getExtension());
	}

	@Test
	public void testWithSpringListAll() {		
		List<Doc> documents = engine.listAll();
		Assertions.assertNotNull(documents);
		Assertions.assertTrue(documents.size() == 4);
	}

}
