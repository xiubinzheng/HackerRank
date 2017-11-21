package com.amazon.onsite.expressiontree;

import java.util.Stack;

/**
 * @author Anatoly Chernysh
 */
public class ExpressionTree {

    public Node constructTree(char postfix[]) {
        final Stack<Node> stack = new Stack<>();
        Node t, t1, t2;

        for (int i = 0;i < postfix.length;i++) {
            if (!isOperator(postfix[i])) {
                t = new Node(postfix[i]);
                stack.push(t);
            }
            else {
                t = new Node(postfix[i]);
                t1 = stack.pop();
                t2 = stack.pop();
                t.setRight(t1);
                t.setLeft(t2);

                stack.push(t);
            }
        }
        return stack.pop();
    }

    private boolean isOperator(char c) {
        if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^') {
            return true;
        }
        return false;
    }

    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.getLeft());
            System.out.print(node.getValue());
            inOrder(node.getRight());
        }
    }

    public static void main(String[] args) {
        ExpressionTree expressionTree = new ExpressionTree();
        String postfix = "ab+ef*g*-";
        char []charArray = postfix.toCharArray();
        Node root = expressionTree.constructTree(charArray);
        expressionTree.inOrder(root);
    }
}
