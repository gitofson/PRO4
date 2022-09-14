package cz.spsmb.ctvrtak.c_spring.a_config.test.java;

import cz.spsmb.ctvrtak.c_spring.a_config.main.java.SearchEngine;
import org.junit.jupiter.api.Test;

public class Assertions {

    private SearchEngine engine = new MySearchEngine();
    @Test
    public void testFindByType() {
        System.out.println(engine.findByType("Milky").toString());
    }
    @Test
    public void testListAll() {
        System.out.println(engine.listAll().toString());
    }

}
