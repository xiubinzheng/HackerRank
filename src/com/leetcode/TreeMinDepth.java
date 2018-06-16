package com.leetcode;

import java.util.Stack;

/**
 * @author Anatoly Chernysh
 */
public class TreeMinDepth {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(minDepth(root));

    }

    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> stackDepth = new Stack<>();

        stack.push(root);
        stackDepth.push(1);

        int minDepth = Integer.MAX_VALUE;

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int currentDepth = stackDepth.pop();

            if (node.left != null) {
                stack.push(node.left);
                stackDepth.push(currentDepth + 1);
            }
            if (node.right != null) {
                stack.push(node.right);
                stackDepth.push(currentDepth + 1);
            }
            if (node.right == null && node.left == null) {
                if (currentDepth < minDepth) {
                    minDepth = currentDepth;
                }
            }

        }

        return minDepth;
    }

}
