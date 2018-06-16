package com.leetcode;

/**
 * @author Anatoly Chernysh
 */
public class BalancedBinaryTree {

    public static void main(String[] args) {
        /*
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(isBalanced(root));
        */

        /*
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);

        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(4);

        System.out.println(isBalanced(root));
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);

        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(4);

        System.out.println(isBalanced(root));

    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        if (Math.abs(rightHeight - leftHeight) <= 1 &&
                isBalanced(root.left) &&
                isBalanced(root.right)) {
            return true;
        }

        return false;
    }

    public static int height(TreeNode node) {
        if (node == null) {
            return 1;
        }

        return 1 + Math.max(height(node.left), height(node.right));
    }

}
