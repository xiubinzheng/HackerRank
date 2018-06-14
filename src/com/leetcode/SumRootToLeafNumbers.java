package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anatoly Chernysh
 */
public class SumRootToLeafNumbers {

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }

        List<String> paths = new ArrayList<>();
        helperSumNumbers(root, String.valueOf(root.val), paths);

        int sum = 0;
        for (String path : paths) {
            sum += Integer.valueOf(path);
        }

        return sum;
    }

    public void helperSumNumbers(TreeNode node, String current, List<String> paths) {
        if (node.left != null) {
            helperSumNumbers(node.left, current + node.left.val, paths);
        }
        if (node.right != null) {
            helperSumNumbers(node.right, current + node.right.val, paths);
        }

        if (node.left == null && node.right == null) {
            paths.add(current);
        }
    }
}
