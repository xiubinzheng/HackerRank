package com.cracking;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Anatoly Chernysh
 */
public class FindSubStringsInString {

    public static void main(String[] args) {
        String testString = "mississippi";
        String []t = {"is", "sip", "hi", "sis", "mi"};
        SuffixTree tree = new SuffixTree(testString);
        tree.getIndexes("mi");
        /*
        for (String s : t) {
            ArrayList<Integer> list = tree.getIndexes(s);
            if (list != null) {
                System.out.println(s + ": " + list.toString());
            }
        }
        */
    }
}

class SuffixTreeNode {

    public char value;

    public HashMap<Character, SuffixTreeNode> children = new HashMap<>();

    public ArrayList<Integer> indexes = new ArrayList<>();

    public SuffixTreeNode() {
    }

    public void insertString (String s, int index) {
        indexes.add(index);
        if (s != null && s.length() > 0) {
            value = s.charAt(0);
            SuffixTreeNode child = null;
            if (children.containsKey(value)) {
                child = children.get(value);
            }
            else {
                child = new SuffixTreeNode();
                children.put(value, child);
            }

            String remainder = s.substring(1);
            child.insertString(remainder, index);
        }
    }

    public ArrayList<Integer> getIndexes(String s) {
        if (s == null || s.length() == 0) {
            return indexes;
        }

        char first = s.charAt(0);
        if (children.containsKey(first)) {
            String remainder = s.substring(1);
            return children.get(first).getIndexes(remainder);
        }

        return null;
    }
}


class SuffixTree {

    public SuffixTreeNode root = new SuffixTreeNode();

    public SuffixTree(String s) {
        for (int i = 0;i< s.length();i++) {
            String suffix = s.substring(i);
            root.insertString(suffix, i);
        }
    }

    public ArrayList<Integer> getIndexes(String s) {
        return root.getIndexes(s);
    }
}