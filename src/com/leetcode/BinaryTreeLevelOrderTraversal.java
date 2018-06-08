package com.leetcode;

import java.util.*;

/**
 * @author Anatoly Chernysh
 */
public class BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(levelOrderBottom(root));
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }

        Queue<Optional<TreeNode>> deque = new ArrayDeque<Optional<TreeNode>>();
        deque.add(Optional.<TreeNode>of(root));
        deque.add(Optional.<TreeNode>empty());

        int level = 0;

        while (!deque.isEmpty()) {
            Optional<TreeNode> node = deque.remove();
            if (!node.isPresent()) {
                level++;
                if (!deque.isEmpty()) {
                    deque.add(Optional.<TreeNode>empty());
                }
                continue;
            }
            if (node.get().left != null) {
                deque.add(Optional.<TreeNode>of(node.get().left));
            }
            if (node.get().right != null) {
                deque.add(Optional.<TreeNode>of(node.get().right));
            }
            if (level >= result.size()) {
                result.add(new ArrayList<>());
            }
            result.get(level).add(node.get().val);
        }

        Collections.reverse(result);
        return result;
    }

}
