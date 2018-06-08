package com.leetcode;

import java.util.Stack;

/**
 * @author Anatoly Chernysh
 */
public class EvaluateReversePolishNotation {

    public static void main(String[] args) {
        // case 1

        String[] tokens = new String[5];
        tokens[0] = "2";
        tokens[1] = "1";
        tokens[2] = "+";
        tokens[3] = "3";
        tokens[4] = "*";
        System.out.println(evalRPN(tokens)); // 9

        /*
        // case 2
        String[] tokens = new String[5];
        tokens[0] = "4";
        tokens[1] = "13";
        tokens[2] = "5";
        tokens[3] = "/";
        tokens[4] = "+";
        System.out.println(evalRPN(tokens)); // 6

        // case 3
        String[] tokens = new String[13];
        tokens[0] = "10";
        tokens[1] = "6";
        tokens[2] = "9";
        tokens[3] = "3";
        tokens[4] = "+";
        tokens[5] = "-11";
        tokens[6] = "*";
        tokens[7] = "/";
        tokens[8] = "*";
        tokens[9] = "17";
        tokens[10] = "+";
        tokens[11] = "5";
        tokens[12] = "+";
        System.out.println(evalRPN(tokens)); // 22

        // case 4
        String[] tokens = new String[3];
        tokens[0] = "4";
        tokens[1] = "3";
        tokens[2] = "-";
        System.out.println(evalRPN(tokens)); // -1
        */
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0;i < tokens.length;i++) {
            String curr = tokens[i];
            if ("+-/*".contains(curr)) {
                int oper1 = stack.pop();
                int oper2 = stack.pop();
                int result = 0;
                switch (curr) {
                    case "+":
                        result = oper1 + oper2;
                        break;
                    case "-":
                        result = oper2 - oper1;
                        break;
                    case "*":
                        result = oper1 * oper2;
                        break;
                    case "/":
                        result = oper2 / oper1;
                        break;
                    default:
                        throw new IllegalArgumentException("Bad operand: " + curr);
                }
                stack.push(result);
            }
            else {
                stack.push(Integer.parseInt(curr));
            }
        }
        return stack.pop();
    }

}
