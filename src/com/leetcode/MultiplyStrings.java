package com.leetcode;

/**
 * @author Anatoly Chernysh
 */
public class MultiplyStrings {

    public static void main(String[] args) {
        System.out.println(multiply("123", "456"));
        //System.out.println(multiply("2", "3"));

    }

    public static String multiply(String num1, String num2) {
        int []multiplyColumns = new int[num1.length() + num2.length()];

        for (int i = num1.length() - 1;i >= 0;i--) {
            for (int j = num2.length() - 1;j >= 0;j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j;
                int p2 = p1 + 1;
                int sum = mul + multiplyColumns[p2];

                multiplyColumns[p1] += sum / 10;
                multiplyColumns[p2] = sum  % 10;
            }
        }

        StringBuilder mult = new StringBuilder();
        for (int value : multiplyColumns) {
            if (!(mult.length() == 0 && value == 0)) {
                mult.append(value);
            }
        }

        return mult.length() == 0 ? "0" : mult.toString();
    }

}
