package com.hakerrank;

import java.util.Scanner;

/**
 * @author Anatoly Chernysh
 */
public class FunnyString {

    public static void main(String []args) {
        Scanner in = new Scanner(System.in);
        int amountTestCases = Integer.parseInt(in.nextLine());

        for(int i = 0;i < amountTestCases;i++){
            String line = in.nextLine();
            System.out.println(isFunny(line) ? "Funny" : "Not Funny");
        }
    }

    public static boolean isFunny(String funny) {
        for (int i = 1;i < funny.length();i++) {
            int leftChar = funny.charAt(i) - funny.charAt(i - 1);
            int rightChar = funny.charAt(funny.length() - i) - funny.charAt(funny.length() - i - 1);
            if (Math.abs(leftChar) != Math.abs(rightChar)) {
                return false;
            }
        }
        return true;
    }
}
