package com.leetcode;

import java.util.Stack;

/**
 * @author Anatoly Chernysh
 */
public class BasicCalculatorII {

    public static void main(String[] args) {
        //System.out.println(calculate("3+2*2"));
        //System.out.println(calculate(" 3/2 "));
        //System.out.println(calculate("3+5/2"));
        //System.out.println(calculate("2*2+3"));
        //System.out.println(calculate("101 + 2 * 6 / 2"));
        //System.out.println(calculate("0-2147483647"));
        //System.out.println(calculate("1-1+1"));
        //System.out.println(calculate("100000000/1/2/3/4/5/6/7/8/9/10"));
        //System.out.println(calculate("123-8*5-57/3+148+1*3/2*14*11*2*5/4*3/3/3+2283"));
        //System.out.println(calculate("1-1-1"));
        //System.out.println(calculate("2*3+4"));
    }

    public static int calculate(String s) {
        Stack<Integer> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();

        char []expression = s.toCharArray();
        for (int i = 0;i < expression.length;i++) {
            char ch = expression[i];
            if (Character.isDigit(ch)) {
                StringBuilder operand = new StringBuilder();
                operand.append(ch);
                i++;
                while (i < expression.length) {
                    ch = expression[i];
                    if (!Character.isDigit(ch)) {
                        break;
                    }
                    operand.append(ch);
                    i++;
                }
                operands.push(Integer.parseInt(operand.toString()));
            }

            if (ch == '+' || ch == '-' ||
                ch == '*' || ch == '/') {
                while (!operators.empty() && hasPrecedence(ch, operators.peek())) {
                    operands.push(operationForValue(operators.pop(), operands.pop(), operands.pop()));
                }
                operators.push(ch);
            }
        }

        while (!operators.empty()) {
            operands.push(operationForValue(operators.pop(), operands.pop(), operands.pop()));
        }

        return operands.pop();
    }

    private static boolean hasPrecedence(char oper1, char oper2) {
        if ((oper1 == '*' || oper1 == '/') && (oper2 == '+' || oper2 == '-')) {
            return false;
        }
        else {
            return true;
        }
    }

    private static int operationForValue(char operator, int op1, int op2) {
        int result = 0;
        switch (operator) {
            case '+':
                result = op1 + op2;
                break;
            case '-':
                result = op2 - op1;
                break;
            case '*':
                result = op1 * op2;
                break;
            case '/':
                result = op2 / op1;
                break;
            default:
                throw new IllegalArgumentException(String.valueOf("Operator [%s] is not supported"));
        }

        return result;
    }
}
