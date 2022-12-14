/**
 * 
 */
package cz.spsmb.ctvrtak.c_spring.i_db1.main.spring.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cz.spsmb.ctvrtak.c_spring.i_db1.main.java.model.Document;
import cz.spsmb.ctvrtak.c_spring.i_db1.main.java.model.Type;

/**
 * @author Felipe Gutierrez
 *
 */
public class DocumentRowMapper implements RowMapper<Document> {

	public Document mapRow(ResultSet rs, int rowNum) throws SQLException {
		Document document = new Document();
		document.setDocumentId(rs.getString("documentId"));
		document.setName(rs.getString("name"));
		document.setLocation(rs.getString("location"));
		document.setCreated(rs.getDate("created"));
		document.setModified(rs.getDate("modified"));
		document.setDescription("doc_desc");
		Type type = new Type();
		type.setTypeId(rs.getString("typeId"));
		type.setName(rs.getString("type_name"));
		type.setDesc(rs.getString("type_desc"));
		type.setExtension(rs.getString("extension"));
		document.setType(type);
		return document;
	}

}
