package com.leetcode;

/**
 * @author Anatoly Chernysh
 */
public class ConstructBinaryTreePreorderInorder {

    public static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder.length == 0) {
            return null;
        }
        return buildTreeHelper(inorder, preorder, 0, inorder.length - 1, 0);
    }

    public static TreeNode buildTreeHelper(int[] inOrder,
                                           int[] preOrder,
                                           int inStart,
                                           int inEnd,
                                           int preStart) {

        if (inStart > inEnd || preStart > preOrder.length - 1) {
            return null;
        }


        TreeNode root = new TreeNode(preOrder[preStart]);
        int divider = -1;

        for (int i = inStart;i <= inEnd;i++) {
            if (inOrder[i] == root.val) {
                divider = i;
                break;
            }
        }

        root.left = buildTreeHelper(inOrder, preOrder, inStart, divider - 1, preStart + 1);
        root.right = buildTreeHelper(inOrder, preOrder, divider + 1, inEnd, preStart + (divider - inStart) + 1);


        return root;
    }


    public static void main(String[] args) {

        /*
        int []preOrder = {3,9,20,15,7};
        int []inOrder = {9,3,15,20,7};
        */


        /*
        int []preOrder = {2, 3, 1};
        int []inOrder = {1, 2, 3};
        */

        int []inOrder = {3,1,2,4};
        int []preOrder  = {1,2,3,4};


        TreeNode node = buildTree(inOrder, preOrder);
        inOrder(node);
    }
}
