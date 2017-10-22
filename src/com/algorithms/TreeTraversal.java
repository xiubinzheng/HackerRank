package com.algorithms;

/**
 * @author Anatoly Chernysh
 */
public class TreeTraversal {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = new Node(1);
        binaryTree.root.left = new Node(2);
        binaryTree.root.right = new Node(3);
        binaryTree.root.left.left = new Node(4);
        binaryTree.root.left.right = new Node(5);

        /*
        System.out.println("Post order:");
        binaryTree.printPostOrder(binaryTree.root);
        */

        /*
        System.out.println("In order:");
        binaryTree.printInOrder(binaryTree.root);
        */

        System.out.println("Pre order:");
        binaryTree.printPreOrder(binaryTree.root);

    }
}

class Node {

    public int key;

    public Node left, right;

    public Node(int item) {
        this.key = item;
        this.left = this.right = null;
    }
}

class BinaryTree {

    public Node root;

    /**
     * Post order traversal: left node, right node, root node.
     */
    public void printPostOrder(Node node) {
       if (node == null) {
           return;
       }
        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.print(node.key + " ");
    }

    /**
     * In order traversal: left node, root node, right node
     */
    public void printInOrder(Node node) {
        if (node == null) {
            return;
        }
        printInOrder(node.left);

        System.out.print(node.key + " ");

        printInOrder(node.right);
    }

    /**
     * Pre order traversal: root node, left node, right node.
     */
    public void printPreOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.key + " ");

        printPreOrder(node.left);

        printPreOrder(node.right);
    }
}