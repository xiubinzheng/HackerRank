package com.leetcode;

/**
 * @author Anatoly Chernysh
 */
public class CountCompleteTreeNodes {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        System.out.println(countNodes(root));
    }

    public static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        TreeNode left = root, right = root;
        int height = 0;
        while (right != null) {
            right = right.right;
            left = left.left;
            height++;
        }

        if (left == null) {
            return (1 << height) - 1;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }


    /*
    static int count = 0;

    public static int countNodes(TreeNode root) {
        count = 0;
        traverse(root);
        return count;
    }

    public static void traverse(TreeNode node) {
        if (node == null) {
            return;
        }

        traverse(node.left);
        count++;
        traverse(node.right);
    }
    */
}
