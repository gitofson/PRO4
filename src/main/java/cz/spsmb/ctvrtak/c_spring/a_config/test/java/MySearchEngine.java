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
    public List<Doc> findByType(String typeName) {
        List<Doc> listus = new ArrayList<>();
        for (int i = 0; i < storage().size(); i++) {
            if (storage().get(i).getType().getName() == typeName)
                listus.add(storage().get(i));
        }
        return listus;
    }
    private List<Doc> storage(){
        List<Doc> docList = new ArrayList<>();
        Type typea = new Type("ahoj","mental breakdown", "stembus");
        Type typeb = new Type("ahoj2", "cotojeproctoje", "bambus");
        Doc doca = new Doc(typea, "ahoj","buruh");
        Doc docb = new Doc(typeb,"bruh", "idk");
        docList.add(doca);
        docList.add(docb);
        return docList;
    }
}
