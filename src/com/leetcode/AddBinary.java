package com.leetcode;

/**
 * @author Anatoly Chernysh
 */
public class AddBinary {

    public static void main(String[] args) {
        //String a = "11", b = "1";
        //String a = "11", b = "11";
        //String a = "1010", b = "1011";
        //System.out.println(addBinary(a, b));
    }

    public static String addBinary(String a, String b) {
        StringBuilder binarySum = new StringBuilder();
        int length = Math.max(a.length(), b.length());
        int carry = 0;

        for (int i = length - 1,
                 j = a.length() - 1,
                 k = b.length() - 1;i >= 0;i--) {
            int item1 = 0, item2 = 0;
            if (j >= 0) {
                item1 = a.charAt(j--) - '0';
            }
            if (k >= 0) {
                item2 = b.charAt(k--) - '0';
            }
            int sum = item1 + item2 + carry;
            switch (sum) {
                case 0:
                    binarySum.append(0);
                    carry = 0;
                    break;
                case 1:
                    binarySum.append(1);
                    carry = 0;
                    break;
                case 2:
                    binarySum.append(0);
                    carry = 1;
                    break;
                case 3:
                    binarySum.append(1);
                    carry = 1;
                    break;
            }
        }
        if (carry == 1) {
            binarySum.append(1);
        }

        return binarySum.reverse().toString();
    }

}
