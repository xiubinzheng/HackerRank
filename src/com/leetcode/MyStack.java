package com.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Anatoly Chernysh
 */
class MyStack {

    private Queue<Integer> queue = new ArrayDeque<Integer>();

    /** Initialize your data structure here. */
    public MyStack() {
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
        while (!queue.isEmpty()) {
            int current = queue.peek();
            if (current == x) {
                break;
            }
            queue.add(queue.remove());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.remove();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }

}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */