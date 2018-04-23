package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Anatoly Chernysh
 */
public class HappyNumber {

    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }

    public static boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }
        Set<Integer> uniqueNumbers = new HashSet<>();
        uniqueNumbers.add(n);
        for (;;) {
            String numbers = String.valueOf(n);
            int sum = 0;
            for (int i = 0;i < numbers.length();i++) {
                int num = numbers.charAt(i) - 48;
                sum += num * num;
            }
            if (n == sum) {
                return false;
            }
            if (sum == 1) {
                return true;
            }
            n = sum;
            if (!uniqueNumbers.add(sum)) {
                return false;
            }
        }
    }
}
