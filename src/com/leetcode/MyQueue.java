package com.leetcode;

import java.util.Stack;

/**
 * @author Anatoly Chernysh
 */
public class MyQueue {

    private Stack<Integer> stack1 = new Stack<Integer>();

    private Stack<Integer> stack2 = new Stack<Integer>();

    private Integer front;


    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if (stack1.empty()) {
            front = x;
        }
        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (!stack2.isEmpty()) {
            return stack2.peek();
        }
        return front;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.empty() && stack2.empty();
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.pop()); // returns 1
        queue.push(3);
        queue.push(4);
        System.out.println(queue.pop()); // returns 2
        System.out.println(queue.peek()); // returns 3
    }
}
