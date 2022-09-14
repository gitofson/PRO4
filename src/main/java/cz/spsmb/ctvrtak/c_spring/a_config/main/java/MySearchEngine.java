package cz.spsmb.ctvrtak.c_spring.a_config.main.java;

import java.util.ArrayList;
import java.util.List;

public class MySearchEngine implements SearchEngine{
    @Override
    public List<Doc> listAll() {

        return storage();
    }

    @Override
    public List<Doc> findByType() {
        return null;
    }
    public List<Doc> storage(){
        List<Doc> arrajlist = new ArrayList<>();
        Type type1 = new Type("name1", "ext1" , "desc1");
        Type type2 = new Type("name2", "ext2" , "desc2");

        Doc doc1 = new Doc("doc1","loc1",  type1);
        Doc doc2 = new Doc("doc2","loc2",  type2);
        arrajlist.add(doc1);
        arrajlist.add(doc2);


        return arrajlist;
    }
}
