package cz.spsmb.ctvrtak.c_spring.n_dynamic_langs.main.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cz.spsmb.ctvrtak.c_spring.n_dynamic_langs.main.java.model.Document;
import cz.spsmb.ctvrtak.c_spring.n_dynamic_langs.main.java.model.Type;
import cz.spsmb.ctvrtak.c_spring.n_dynamic_langs.main.java.service.DocumentService;
import cz.spsmb.ctvrtak.c_spring.n_dynamic_langs.main.spring.data.DocumentDAO;

/**
 * @author Felipe Gutierrez
 *
 */
@Component("documentFacade")
public class DocumentServiceFacade implements DocumentService {

    @Autowired
    DocumentDAO documentDAO;

    public List<Document> getAllDocuments(){
        return documentDAO.getAll();
    }

    public Document saveDocument(String id, Document document) {
        return documentDAO.save(id, document);
    }

    public Document removeDocumentById(String id) {
        return documentDAO.removeById(id);
    }

    public Document findDocumentById(String id){
        return documentDAO.findById(id);
    }

    public boolean updateLocationFromDocumentId(String documentId, String location) {
        Document document = documentDAO.findById(documentId);
        if(null == document)
            return false;
        document.setLocation(location);
        saveDocument(documentId, document);
        return true;
    }

    public List<Document> findByType(Type type) {
        return documentDAO.findByTypeName(type.getName());
    }

}
