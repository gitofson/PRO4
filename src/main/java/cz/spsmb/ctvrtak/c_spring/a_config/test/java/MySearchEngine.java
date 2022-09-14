package cz.spsmb.ctvrtak.c_spring.a_config.test.java;

import cz.spsmb.ctvrtak.c_spring.a_config.main.java.SearchEngine;

import javax.print.Doc;
import java.util.List;

public class MySearchEngine implements SearchEngine {
    @Override
    public List<Doc> listAll() {
        return null;
    }

    @Override
    public List<Doc> findByType() {
        return null;
    }
}
