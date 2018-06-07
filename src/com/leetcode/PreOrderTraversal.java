package com.leetcode;

import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * @author Anatoly Chernysh
 */
public class PreOrderTraversal {

    public static void main(String[] args) {
        /*
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(preorderTraversal(root));
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(preorderTraversal(root));

    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.EMPTY_LIST;
        }

        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);

            if (node.right == null && node.left == null) {
                continue;
            }

            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return result;
    }
}
