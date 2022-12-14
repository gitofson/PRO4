/**
 * 
 */
package cz.spsmb.ctvrtak.c_spring.b_config2.main.data;


import cz.spsmb.ctvrtak.c_spring.a_config.main.java.Type;

/**
 * @author Felipe Gutierrez
 *
 */
public class TypeDataRepository implements TypeDataDAO{

	private Type pdfType;
	private Type webType;
	private Type noteType;
		
	public Type getPdfType() {
		return pdfType;
	}
		public void setPdfType(Type pdfType) {
		this.pdfType = pdfType;
	}
	public Type getWebType() {
		return webType;
	}
	public void setWebType(Type webType) {
		this.webType = webType;
	}
	public Type getNoteType() {
		return noteType;
	}
	public void setNoteType(Type noteType) {
		this.noteType = noteType;
	}
	public Type[] getAll() {		
		return new Type[] { pdfType, webType, noteType};
	}
	
	
}
