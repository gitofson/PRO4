package cz.spsmb.ctvrtak.c_spring.a_config.test.java;

import cz.spsmb.ctvrtak.b_anotace.A;
import cz.spsmb.ctvrtak.c_spring.a_config.main.java.Doc;
import cz.spsmb.ctvrtak.c_spring.a_config.main.java.SearchEngine;
import cz.spsmb.ctvrtak.c_spring.a_config.main.java.Type;

import java.util.ArrayList;
import java.util.List;

public class MySearchEngine implements SearchEngine {

    public List<Doc> docs;

    @Override
    public List<Doc> listAll() {
        storage();
        return docs;
    }

    @Override
    public List<Doc> findByType(String typeName) {
        List<Doc> list = new ArrayList<>();
        for (int i = 0; i < storage().size(); i++) {
            if(storage().get(i).getType().getName() == typeName)
                list.add(storage().get(i));
        }
        if (!list.isEmpty()) return list;
        else return null;
    }

    private List<Doc> storage() {
        List<Doc> storageList = new ArrayList<>();
        storageList.add(new Doc("MILK", "Poland", new Type("Milky", "i like milk", "no fucking way")));
        storageList.add(new Doc("TACO", "Mexico", new Type("Taco", "i don't like tacos", "i guess it depends")));
        docs = storageList;
        return storageList;
    }
}
