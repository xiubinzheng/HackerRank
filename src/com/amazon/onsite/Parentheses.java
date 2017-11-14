package com.amazon.onsite;

import java.util.Stack;

/**
 * @author Anatoly Chernysh
 */
public class Parentheses {

    public static void main(String[] args) {
        String givenString = "()())";
        System.out.println(checkParentheses(givenString));
    }

    public static boolean checkParentheses(String givenString) {
        if (givenString == null) {
            return false;
        }
        // I didn't check the use case, if given string is empty, so result is true
        if (givenString.equals("")) {
            return true;
        }

        // I didn't use generic type for Stack.
        // I have used new ArrayList() instead of new Stack<Character>()
        Stack<Character> stack = new Stack<Character>();
        stack.push(givenString.charAt(0));

        // I didn't write length correctly. It should be length()
        for (int i = 1;i < givenString.length();i++) {
            char current = givenString.charAt(i);
            // I didn't check the use, when stack is empty, but i'm trying to do peek
            if (current == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            }
            else {
                stack.push(current);
            }
        }

        return stack.isEmpty();
    }

}
