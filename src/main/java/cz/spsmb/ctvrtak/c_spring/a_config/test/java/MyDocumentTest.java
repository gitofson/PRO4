package cz.spsmb.ctvrtak.c_spring.a_config.test.java;

import cz.spsmb.ctvrtak.c_spring.a_config.main.java.SearchEngine;
import org.junit.jupiter.api.Test;

public class MyDocumentTest {

    private SearchEngine engine = new MySearchEngine();

    @Test
    void testFindByType(){
        engine.findByType();
    }

    @Test
    void testListAll(){
        engine.listAll();
    }

}
