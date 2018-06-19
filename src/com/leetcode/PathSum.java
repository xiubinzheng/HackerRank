package com.leetcode;

/**
 * @author Anatoly Chernysh
 */
public class PathSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        System.out.println(hasPathSum(root, 22));
    }

    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.right == null && root.left == null) {
            return root.val == sum;
        }

        return findSum(root, root.val, sum);
    }

    public static boolean findSum(TreeNode root, int sum, int target) {
       if (root.left == null && root.right == null) {
           return target == sum;
       }

        boolean result = false;
        if (root.left != null) {
            result = findSum(root.left, sum + root.left.val, target);
        }
        if (root.right != null && !result) {
            result = findSum(root.right, sum + root.right.val, target);
        }

        return result;
    }

}
