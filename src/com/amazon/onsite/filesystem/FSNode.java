package com.amazon.onsite.filesystem;

/**
 * @author Anatoly Chernysh
 */
public abstract class FSNode {

    private String name;

    private String path;

    public abstract boolean isFile();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
