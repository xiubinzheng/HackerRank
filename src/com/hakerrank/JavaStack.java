package com.hakerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @author Anatoly Chernysh
 */
public class JavaStack {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        for (; ; ) {
            String string = in.readLine();
            if (string.equals("")) {
                return;
            }

            ArrayList<Character> braces = new ArrayList<Character>();
            ArrayList<Character> parentheses = new ArrayList<Character>();
            ArrayList<Character> brackets = new ArrayList<Character>();

            for (int i = 0; i < string.length(); i++) {
                char ch = string.charAt(i);
                if (ch == '{' || ch == '}') {
                    braces.add(ch);
                } else if (ch == '(' || ch == ')') {
                    parentheses.add(ch);
                } else if (ch == '[' || ch == ']') {
                    brackets.add(ch);
                }
            }

            if (!braces.isEmpty()) {
                checkBrackets(braces, '{');
                if (!checkFulfillment(braces)) {
                    System.out.println("false");
                    continue;
                }
            }

            if (!parentheses.isEmpty()) {
                checkBrackets(parentheses, '(');
                if (!checkFulfillment(parentheses)) {
                    System.out.println("false");
                    continue;
                }
            }

            if (!brackets.isEmpty()) {
                checkBrackets(brackets, '[');
                if (!checkFulfillment(brackets)) {
                    System.out.println("false");
                    continue;
                }
            }

            System.out.println("true");
        }
    }

    private static boolean checkFulfillment(ArrayList<Character> characters) {
        int count = 0;
        for (int i = 0; i < characters.size(); i++) {
            if (characters.get(i) == '0') {
                count++;
            }
        }
        if (characters.size() == count) {
            return true;
        }

        return false;
    }

    private static void checkBrackets(ArrayList<Character> characters, char startChar) {
        if (checkFulfillment(characters)) {
            return;
        }

        for (int i = 0; i < characters.size(); i++) {
            char current = characters.get(i);
            char next = '0';
            for (int j = i + 1; j < characters.size(); j++) {
                if (characters.get(j) != '0') {
                    next = characters.get(j);

                    if (current != next && current == startChar) {
                        characters.set(i, '0');
                        characters.set(j, '0');
                        checkBrackets(characters, startChar);
                    }

                    break;
                }
            }
            if (next == '0') {
                return;
            }
        }
    }
}
