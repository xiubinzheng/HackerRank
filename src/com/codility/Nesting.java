package com.codility;

import java.util.Stack;

/**
 * @author Anatoly Chernysh
 */
public class Nesting {

    public static void main(String[] args) {
        System.out.println(solution("())"));
    }

    public static int solution(String S) {
        Stack<Character> nesting = new Stack<Character>();

        for (int i = 0;i < S.length();i++) {
            char newValue = S.charAt(i);
            if (!nesting.isEmpty()) {
                char preValue = nesting.peek();
                if (preValue == '(' && newValue == ')') {
                    nesting.pop();
                }
                else {
                    nesting.push(newValue);
                }
            }
            else {
                nesting.push(newValue);
            }
        }

        return nesting.isEmpty() ? 1 : 0;
    }
}
