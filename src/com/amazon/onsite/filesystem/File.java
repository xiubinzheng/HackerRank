package com.amazon.onsite.filesystem;

/**
 * @author Anatoly Chernysh
 */
public class File extends FSNode {

    @Override
    public boolean isFile() {
        return true;
    }
}
