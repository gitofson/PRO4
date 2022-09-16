package cz.spsmb.ctvrtak.c_spring.a_config.main.java;

public class Doc {

    private String name, location;
    private Type type;

    public Doc(String name, String location, Type type) {
        this.name = name;
        this.location = location;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
