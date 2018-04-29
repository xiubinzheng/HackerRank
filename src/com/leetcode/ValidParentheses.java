package com.leetcode;

import java.util.Stack;

/**
 * @author Anatoly Chernysh
 */
public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("{[]}"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0;i < s.length();i++) {
            char ch = s.charAt(i);
            if (ch == '[' || ch == '(' || ch == '{') {
                stack.push(ch);
            }
            else {
                if (stack.isEmpty()) {
                    return false;
                }
                char prev = stack.pop();
                if (!((prev == '[' && ch == ']') ||
                    (prev == '(' && ch == ')') ||
                    (prev == '{' && ch == '}'))) {
                    return false;
                }
            }
        }

        return stack.empty();
    }

}
