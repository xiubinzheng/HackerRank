package com.leetcode;

import java.util.Stack;

/**
 * @author Anatoly Chernysh
 */
public class MinStack {

    private Stack<Integer> stack  = new Stack<>();

    private Stack<Integer> minStack = new Stack<>();

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        stack.push(x);
        if (!minStack.empty()) {
            if (x > minStack.peek()) {
                minStack.push(minStack.peek());
            }
            else {
                minStack.push(x);
            }
        }
        else {
            minStack.push(x);
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println();
        System.out.println(minStack.getMin()); // Returns -3.
        minStack.pop();
        System.out.println(minStack.top()); // Returns 0
        System.out.println(minStack.getMin()); // Returns -2
    }

}
