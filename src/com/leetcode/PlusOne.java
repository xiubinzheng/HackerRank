package com.leetcode;

/**
 * @author Anatoly Chernysh
 */
public class PlusOne extends Base {

    public static void main(String[] args) {
        int ten[] = {9};
        dump(plusOne(ten));
    }

    public static int[] plusOne(int[] digits) {
        int carry = 0, plusOne = 1;
        for (int i = digits.length - 1;i >= 0;i--) {
            if (digits[i] + carry + plusOne >= 10) {
                digits[i] = 0;
                carry = 1;
                plusOne = 0;
                if (i == 0) {
                    int []resizedDigits = new int[digits.length + 1];
                    resizedDigits[0] = 1;
                    System.arraycopy(digits, 0, resizedDigits, 1, digits.length);
                    return resizedDigits;
                }
            }
            else {
                digits[i] = (digits[i] + plusOne + carry);
                break;
            }
        }
        return digits;
    }

}
