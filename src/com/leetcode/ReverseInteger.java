package com.leetcode;

/**
 * @author Anatoly Chernysh
 */
public class ReverseInteger {

    public static void main(String[] args) {
        System.out.println(reverse(123));
        //System.out.println(reverse(-123));
        //System.out.println(reverse(120));
    }

    public static int reverse(int x) {
        long reversedNumber = 0;
        int minus = 1;
        if (x < 0) {
            minus = -1;
            x = x * minus;
        }

        while (x > 0) {
            reversedNumber = reversedNumber * 10 + x % 10;
            if ((reversedNumber > Integer.MAX_VALUE && minus == 1) ||
                (reversedNumber > Integer.MAX_VALUE - 1 && minus == -1)) {
                return 0;
            }

            x = x / 10;
        }
        return (int)(minus * reversedNumber);
    }

}
