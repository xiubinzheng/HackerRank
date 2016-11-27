package com.algorithms;

/**
 * @author Anatoly Chernysh
 */
public class TernarySearchTrie {

    private Node root;

    private class Node {
        char c;
        Node left, right, mid;
        Object val;
    }

    private Node get(Node node, String key, int d) {
        if (node == null) {
            return null;
        }
        char c = key.charAt(d);
        if (c < node.c) {
            return get(node.left, key, d);
        }
        else if (c > node.c) {
            return get(node.right, key, d);
        }
        else if (d < key.length() - 1) {
            return get(node.mid, key, d + 1);
        }
        else {
            return node;
        }
    }

    public Object get(String key) {
        Node node = get(root, key, 0);
        if (node == null) {
            return null;
        }
        return node.val;
    }

    private Node put(Node node, String key, Object val, int d) {
        char c = key.charAt(d);
        if (node == null) {
            node = new Node();
            node.c = c;
        }
        if (c < node.c) {
            node.left = put(node.left, key, val, d);
        }
        else if (c > node.c) {
            node.right = put(node.right, key, val, d);
        }
        else if (d < key.length() - 1) {
            node.mid = put(node.mid, key, val, d + 1);
        }
        else {
            node.val = val;
        }

        return node;
    }

    public void put(String key, Object val) {
        root = put(root, key, val, 0);
    }

    public static void main(String[] args) {
        TernarySearchTrie ternarySearchTrie = new TernarySearchTrie();
        ternarySearchTrie.put("test", 10);
        ternarySearchTrie.put("bob", 12);
        ternarySearchTrie.put("jon", 15);
        ternarySearchTrie.put("tester", 13);
        System.out.println(ternarySearchTrie.get("tester"));
    }

}
