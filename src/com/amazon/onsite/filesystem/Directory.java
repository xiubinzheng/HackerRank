package com.amazon.onsite.filesystem;

import java.util.List;

/**
 * @author Anatoly Chernysh
 */
public class Directory extends FSNode {

    private List<FSNode> nodes;

    public List<FSNode> getNodes() {
        return nodes;
    }

    public void setNodes(List<FSNode> nodes) {
        this.nodes = nodes;
    }

    @Override
    public boolean isFile() {
        return false;
    }
}