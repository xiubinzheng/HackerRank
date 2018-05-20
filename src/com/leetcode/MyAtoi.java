package com.leetcode;

/**
 * @author Anatoly Chernysh
 */
public class MyAtoi {

    public static void main(String[] args) {
        /*
        System.out.println(myAtoi("   -42"));
        System.out.println(myAtoi("42"));
        System.out.println(myAtoi("4193 with words"));
        System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi("-91283472332"));
        System.out.println(myAtoi("+-2"));
        System.out.println(myAtoi("+2"));
        System.out.println(myAtoi("   +0 123"));
        */
        /*
        System.out.println(myAtoi("9223372036854775808"));
        System.out.println(myAtoi("-   234"));
        System.out.println(myAtoi("6-1"));
        System.out.println(myAtoi("-5-"));
        System.out.println(myAtoi("-13+8"));
        System.out.println(myAtoi("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000522545459"));
        System.out.println(myAtoi("1000000522"));
        System.out.println(myAtoi("  0000000000012345678"));
        */

        System.out.println(myAtoi("    0000000000000   "));
    }

    public static int myAtoi(String str) {
        if (str == null) {
            return 0;
        }

        // remove spaces
        boolean minus = false, plus = false;
        StringBuilder tmp = new StringBuilder();
        for (int i = 0;i < str.length();i++) {
            char ch = str.charAt(i);
            if (ch == '-') {
                if (tmp.length() > 0 || minus) {
                    break;
                }
                minus = true;
                if (plus) {
                    return 0;
                }
                continue;
            }
            if (ch == '+') {
                if (tmp.length() > 0 || plus) {
                    break;
                }
                plus = true;
                if (minus) {
                    return 0;
                }
                continue;
            }
            if (ch == ' ') {
                if (tmp.length() > 0 || minus || plus) {
                    break;
                }
                continue;
            }
            if (ch >= '0' && ch <= '9') {
                tmp.append(ch);
            } else {
                break;
            }
        }

        if (tmp.length() == 0) {
            return 0;
        }


        // remove leading zeros
        boolean found = false;
        for (int i = tmp.length() - 1;i >= 0;i--) {
            if (tmp.charAt(i) != '0') {
                str = tmp.substring(i);
                found = true;
            }
        }
        if (!found) {
            str = "";
        }

        // convert to number
        long result = 0, digit = 1;
        for (int i = str.length() - 1;i >= 0;i--) {
            char ch = str.charAt(i);
            int number = 0;
            if (ch >= '0' && ch <= '9') {
                number = (int)(ch - '0');
            }
            result += number * digit;
            if (result > Integer.MAX_VALUE || digit > Integer.MAX_VALUE) {
                return minus ?  Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            digit *= 10;
        }
        result = minus ? -1 * result : result;
        return (int)result;
    }
}
