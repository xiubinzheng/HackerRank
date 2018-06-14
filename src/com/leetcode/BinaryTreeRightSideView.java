package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Anatoly Chernysh
 */
public class BinaryTreeRightSideView {


    /*
        public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left = new TreeNode(4);
        System.out.println(rightSideView(root));
    }
    */

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        result.add(root.val);

        int maxDepth = 0;
        Stack<Integer> stackDepth = new Stack<>();
        stackDepth.push(maxDepth);

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


            if (currentDepth > maxDepth) {
                result.add(node.val);
                maxDepth = currentDepth;
            }
        }

        return result;
    }
}
