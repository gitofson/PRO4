package cz.spsmb.ctvrtak.c_spring.a_config.main.java;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyDocumentTest {
    private SearchEngine engine = new MySearchEngine();
    @Test
    public void testFindByType(){

        engine.findByType();


    }
    @Test
    public void  testListAll(){
        engine.listAll();

    }
    @Test
    public void Assertions() {
      //  String expected = ;
    //    String actual = ;

     //   assertEquals(expected, actual);
//
    }


}
