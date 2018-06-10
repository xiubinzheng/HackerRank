package com.leetcode;

/**
 * @author Anatoly Chernysh
 */
public class SymmetricTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        //root.right.left.right = new TreeNode(5);
        System.out.println(isSymmetric(root));
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    private static boolean isMirror(TreeNode node1, TreeNode node2) {
        if (node1 == node2 && node1 == null) {
            return true;
        }
        if (node2 == null || node1 == null) {
            return false;
        }
        if (node1.val != node2.val) {
            return false;
        }
        return isMirror(node1.left, node2.right) &&
                isMirror(node2.left, node1.right);
    }

}
