package com.leetcode;

/**
 * @author Anatoly Chernysh
 */
public class ExcelSheetColumnTitle {

    public static void main(String[] args) {
        System.out.println(convertToTitle(28));
    }

    public static String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();

        while (n > 0) {
            n--;
            result.insert(0, (char)('A' + (n % 26)));
            n /= 26;
        }

        return result.toString();
    }
}
