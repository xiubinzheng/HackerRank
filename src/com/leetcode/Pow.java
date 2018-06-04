package com.leetcode;

/**
 * @author Anatoly Chernysh
 */
public class Pow {

    public static void main(String[] args) {
        //System.out.println(myPow(2, 10));
        //System.out.println(myPow(2.1, 3));
        System.out.println(myPow(2, -2));
        //System.out.println(myPow(1.00000, -2147483648));
    }

    /*
    public static double myPow(double x, int n) {
        boolean minus = n < 0;
        if (minus) {
            n = -n;
        }
        if (n == 0) {
            return 1;
        }

        double result = x;
        for (int i = 0;i < n - 1;i++) {
            result *= x;
        }
        return minus ? 1 / result : result;
    }
    */


    public static double myPow(double x, int n) {
        boolean minus = n < 0;
        double result = helperMyPow(x, n);
        if (minus) {
            result = 1 / Math.abs(result);
            if (result == Double.POSITIVE_INFINITY) {
                return 0;
            }
            return result;
        }
        return result;
    }


    public static double helperMyPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        double tmp = helperMyPow(x, n / 2);
        if (n % 2 == 0) {
            return tmp * tmp;
        }
        else {
            return x * tmp * tmp;
        }
    }


}
