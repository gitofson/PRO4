package cz.spsmb.ctvrtak.c_spring.a_config.test.java;

import cz.spsmb.ctvrtak.c_spring.a_config.main.java.SearchEngine;
import cz.spsmb.ctvrtak.c_spring.a_config.main.java.Type;
import org.junit.jupiter.api.Test;

public class MyDocumentTest {
    private SearchEngine engine = new MySearchEngine();
//není celé, vysvětlení v Zadání
    @Test
    public void testFindByType() {
        System.out.println(
                engine.findByType("ahoj")

        );
    }

    @Test
    public void testListAll(){
        engine.listAll();
    }

}