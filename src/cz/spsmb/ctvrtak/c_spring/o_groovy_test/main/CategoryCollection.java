package cz.spsmb.ctvrtak.c_spring.o_groovy_test.main;

import java.time.LocalTime;
import java.util.List;
import java.util.Random;

public class CategoryCollection {
    private List<TestCollection> categoryCollection;


    public void setCategoryCollection(List<TestCollection> categoryCollection) {
        this.categoryCollection = categoryCollection;
    }
    public TestCollection getRandomCategory(){
        Random rnd = new Random();
        return categoryCollection.get(rnd.nextInt(categoryCollection.size()));
    }
}
