package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Anatoly Chernysh
 */
public class BinaryTreePaths {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        System.out.println(binaryTreePaths(root));
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<String> paths = new ArrayList<>();
        dfs(root, String.valueOf(root.val), paths);

        return paths;
    }

    private static void dfs(TreeNode node, String current, List<String> paths) {
        if (node.left != null) {
            dfs(node.left, current + "->" + node.left.val, paths);
        }
        if (node.right != null) {
            dfs(node.right, current + "->" + node.right.val, paths);
        }
        if (node.right == null && node.left == null) {
            paths.add(current);
        }
    }

}
