package cz.spsmb.ctvrtak.c_spring.a_config.test.java;

import cz.spsmb.ctvrtak.c_spring.a_config.main.java.Doc;
import cz.spsmb.ctvrtak.c_spring.a_config.main.java.SearchEngine;
import cz.spsmb.ctvrtak.c_spring.a_config.main.java.Type;

import java.util.ArrayList;
import java.util.List;

public class MySearchEngine implements SearchEngine {


    @Override
    public List<Doc> listAll() {
        return storage();
    }

    @Override
    public List<Doc> findByType() {
        return null;
    }

    private List<Doc> storage(){

        List<Doc> strorageList = new ArrayList<>();
        strorageList.add(new Doc("", "", new Type("", "", "")));
        strorageList.add(new Doc("", "", new Type("", "", "")));

        return strorageList;
    }
}
