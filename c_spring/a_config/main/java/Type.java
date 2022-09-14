package cz.spsmb.ctvrtak.c_spring.a_config.main.java;

public class Type {
    String name;

    public Type(String name, String extension, String desc) {
        this.name = name;
        this.extension = extension;
        this.desc = desc;
    }

    String extension;
    String desc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
