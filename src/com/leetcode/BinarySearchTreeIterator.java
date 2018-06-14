package com.leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Anatoly Chernysh
 */
public class BinarySearchTreeIterator {

    Iterator<Integer> iterator;

    /*
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(7);
        root.right = new TreeNode(10);
        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(13);

        BSTIterator bstIterator = new BSTIterator(root);
        while (solution.hasNext()) {
            System.out.println(bstIterator.next());
        }
    }
    */

    public BinarySearchTreeIterator(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        iterator = list.iterator();
    }

    private void inOrder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }

        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);
    }

    public boolean hasNext() {
        return iterator.hasNext();
    }

    public int next() {
        return iterator.next();
    }
}
