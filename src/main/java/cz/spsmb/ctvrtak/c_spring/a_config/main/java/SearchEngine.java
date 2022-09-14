package cz.spsmb.ctvrtak.c_spring.a_config.main.java;

import javax.print.Doc;
import java.util.List;

public interface SearchEngine {
    List<Doc> listAll();
    List<Doc> findByType();
}
