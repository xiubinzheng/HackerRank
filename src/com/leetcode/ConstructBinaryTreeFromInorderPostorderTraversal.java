package com.leetcode;

/**
 * @author Anatoly Chernysh
 */
public class ConstructBinaryTreeFromInorderPostorderTraversal {

    public static void main(String[] args) {
        /*
        int []inorder = {9,3,15,20,7};
        int []postorder = {9,15,7,20,3};

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        */

        /*
        int []inorder = {9};
        int []postorder = {9};
        */

        /*
        int []inorder = {3, 2, 1};
        int []postorder = {3, 2, 1};
        */

        /*
        int []inorder = {1, 2, 3, 4};
        int []postorder = {4, 3, 2, 1};
        */

        /*
        int []inorder = {1,2,3,4,5};
        int []postorder = {5,4,3,2,1};
        */

        /*
        int []inorder = {1,2,3,4,5,6};
        int []postorder = {4,3,6,5,2,1};
        */

        int []inorder = {1,2,3,4};
        int []postorder = {2,1,4,3};

        TreeNode newRoot = buildTree(inorder, postorder);
        System.out.println("in order");
        inOrder(newRoot);
        System.out.println("\r\npost order");
        postOrder(newRoot);
    }

    public static void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }

    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }


    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) {
            return null;
        }
        return buildTreeHelper(inorder, postorder, 0, inorder.length - 1, postorder.length - 1);
    }

    public static TreeNode buildTreeHelper(int[] inOrder,
                                           int[] postOrder,
                                           int inStart,
                                           int inEnd,
                                           int postStart) {

        if (inStart > inEnd || postStart > postOrder.length - 1) {
            return null;
        }

        TreeNode root = new TreeNode(postOrder[postStart]);
        int divider = -1;

        for (int i = inStart;i <= inEnd;i++) {
            if (inOrder[i] == postOrder[postStart]) {
                divider = i;
                break;
            }
        }

        root.left = buildTreeHelper(inOrder, postOrder, inStart, divider - 1, postStart - inEnd + divider - 1);
        root.right = buildTreeHelper(inOrder, postOrder, divider + 1, inEnd, postStart - 1);

        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}