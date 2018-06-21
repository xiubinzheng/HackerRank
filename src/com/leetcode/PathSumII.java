package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anatoly Chernysh
 */
public class PathSumII {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        System.out.println(pathSum(root, 22));
    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return new ArrayList<>();
        }
        if (root.right == null && root.left == null) {
            if (root.val == sum) {
                List<Integer> path = new ArrayList<>();
                path.add(root.val);

                List<List<Integer>> result = new ArrayList<>();
                result.add(path);
                return result;
            }
        }

        List<List<Integer>> paths = new ArrayList<>();
        sum(root, root.val, sum, root.val + ",", paths);
        return paths;
    }

    public static void sum(TreeNode root, int sum, int target, String path, List<List<Integer>> paths) {
        if (root.left == null && root.right == null) {
            if (target == sum) {
                String []values = path.split(",");
                List<Integer> pathResult = new ArrayList<>();
                for (String value : values) {
                    if (!value.isEmpty()) {
                        pathResult.add(Integer.valueOf(value));
                    }
                }
                paths.add(pathResult);
            }
            return;
        }

        if (root.left != null) {
            sum(root.left, sum + root.left.val, target, path + "," + root.left.val, paths);
        }
        if (root.right != null) {
            sum(root.right, sum + root.right.val, target, path + ',' + root.right.val, paths);
        }
    }

}
