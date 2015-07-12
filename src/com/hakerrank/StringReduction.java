package com.hakerrank;

import java.util.Scanner;

/**
 * @author Anatoly Chernysh
 */
public class StringReduction {

    static int stringReduction(String str) {
        int amountOfA = 0;
        int amountOfB = 0;
        int amountOfC = 0;

        for (int i = 0;i < str.length();i++) {
            char ch = str.charAt(i);
            if (ch == 'a') {
                amountOfA++;
            }
            else if (ch == 'b') {
                amountOfB++;
            }
            else if (ch == 'c') {
                amountOfC++;
            }
        }

        if (amountOfA == str.length() || amountOfB == str.length() || amountOfC == str.length()) {
            return str.length();
        }

        return (amountOfA % 2 == 0 && amountOfB % 2 == 0 && amountOfC % 2 == 0) ||
                (amountOfA % 2 == 1 && amountOfB % 2 == 1 && amountOfC % 2 == 1)? 2 : 1;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        int _t_cases = Integer.parseInt(in.nextLine());
        for (int _t_i = 0; _t_i<_t_cases; _t_i++) {
            String _a = in.nextLine();
            res = stringReduction(_a);
            System.out.println(res);
        }
    }
}