package cz.spsmb.ctvrtak.c_spring.a_config.main.java;

public class Type {

    String name;
    String desc;
    String extension;

    public Type(String name, String desc, String extension) {
        this.name = name;
        this.desc = desc;
        this.extension = extension;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }
}
