package com.leetcode;

/**
 * @author Anatoly Chernysh
 */
public class RomanToInt {

    public int romanToInt(String s) {
        int total = 0;

        for (int i = 0;i < s.length();i++) {
            if (i + 1 >= s.length()) {
                total += convert(s.charAt(i));
                break;
            }

            char current = s.charAt(i), next = s.charAt(i + 1);
            int currentDigit = convert(current), nextDigit = convert(next);

            if (currentDigit == nextDigit) {
                total += currentDigit;
            }
            else if (currentDigit > nextDigit) {
                total += currentDigit;
            }
            else {
                total += (nextDigit - currentDigit);
                i++;
            }

        }

        return total;
    }

    private int convert(char ch) {
        switch (ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }

        return -1;
    }
}
