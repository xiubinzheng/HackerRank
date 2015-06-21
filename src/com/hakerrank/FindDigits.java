package com.hakerrank;

import java.util.Scanner;

/**
 * @author Anatoly Chernysh
 */
public class FindDigits {

    private static final int ASCII_VALUE_OF_ZERO = 48;

    public static void main(String []args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0;i < n;i++){
            System.out.println(findDigits(in.nextInt()));
        }
    }

    public static int findDigits(int number) {
        int count = 0;

        String strNumber = String.valueOf(number);
        for (int i = 0;i < strNumber.length();i++) {
            char ch = strNumber.charAt(i);

            int digit = (new Integer(ch) - ASCII_VALUE_OF_ZERO);
            if (digit != 0 && number % digit == 0) {
                count++;
            }
        }

        return count;
    }
}
