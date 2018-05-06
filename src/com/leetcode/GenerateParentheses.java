package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anatoly Chernysh
 */
public class GenerateParentheses {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        generateAll(new char[2 * n], 0, result);
        return result;
    }

    private static void generateAll(char []current, int pos, List<String> result) {
        if (pos == current.length) {
            if (valid(current)) {
                result.add(new String(current));
            }
        }
        else {
            current[pos] = '(';
            generateAll(current, pos + 1, result);
            current[pos] = ')';
            generateAll(current, pos + 1, result);
        }
    }

    private static boolean valid(char []current) {
        int balance = 0;
        for (char ch : current) {
            if (ch == '(') {
                balance++;
            } else {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }
}
