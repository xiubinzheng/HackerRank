package com.leetcode;

/**
 * @author Anatoly Chernysh
 */
public class ValidateBinarySearchTree {

    public static void main(String[] args) {
        /*
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(isValidBST(root)); // true
        */

        /*
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);
        System.out.println(isValidBST(root)); // false
        */


        /*
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(15);
        System.out.println(isValidBST(root)); // false
        */

        TreeNode root = new TreeNode(-2147483648);
        root.left = new TreeNode(-2147483648);
        System.out.println(isValidBST(root)); // false

    }

    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }

        if (root.val < min || root.val > max) {
            return false;
        }

        return isValidBST(root.left, min, (long)root.val - 1) &&
                isValidBST(root.right, (long)root.val + 1, max);
    }

}
