package com.amazon.onsite.filesystem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Anatoly Chernysh
 */
public class FileSystem {

    public static Set<String> findPaths(Directory root, String fileName) {
        final Set<String> paths = new HashSet<>();

        if (root.getName().equals(fileName)) {
            paths.add(root.getPath());
            return paths;
        }

        for (FSNode node : root.getNodes()) {
            if (node.isFile() && node.getName().equals(fileName)) {
                paths.add(node.getPath());
            }
            else {
                helperFindPaths((Directory)node, fileName, paths);
            }
        }

        return paths;
    }

    public static void helperFindPaths(Directory root, String fileName, Set<String> paths) {
        if (root == null) {
            return;
        }

        for (FSNode node : root.getNodes()) {
            if (node.isFile()) {
                if (node.getName().equals(fileName)) {
                    paths.add(node.getPath());
                }
            }
            else {
                helperFindPaths((Directory)node, fileName, paths);
            }
        }
    }

    public static void main(String[] args) {
        Directory root = new Directory();
        root.setName("root");
        root.setPath("/");
        root.setNodes(new ArrayList<FSNode>());

        File file = new File();
        file.setName("root.txt");
        file.setPath("/root/");
        root.getNodes().add(file);

        Directory directory = new Directory();
        directory.setName("directory");
        directory.setPath("root/directory");
        directory.setNodes(new ArrayList<FSNode>());
        root.getNodes().add(directory);

        File file1 = new File();
        file1.setName("root.txt");
        file1.setPath("/root/directory/");
        directory.getNodes().add(file1);

        File file2 = new File();
        file2.setName("file.txt");
        file2.setPath("/root/directory/");
        directory.getNodes().add(file2);

        System.out.println(FileSystem.findPaths(root, "root.txt"));
    }

}
