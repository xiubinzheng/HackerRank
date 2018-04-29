package com.leetcode;

/**
 * @author Anatoly Chernysh
 */
public class CountAndSay {

    public static void main(String[] args) {
        System.out.println(countAndSay(1).equals("1"));
        System.out.println(countAndSay(2).equals("11"));
        System.out.println(countAndSay(3).equals("21"));
        System.out.println(countAndSay(4).equals("1211"));
        System.out.println(countAndSay(5).equals("111221"));
        System.out.println(countAndSay(6).equals("312211"));
        System.out.println(countAndSay(7).equals("13112221"));
    }

    public static String countAndSay(int n) {
        StringBuilder result = new StringBuilder();

        for (int i = 1;i <= n;i++) {
            if (i == 1) {
                result.append("1");
                continue;
            }
            else if (i == 2) {
                result.append("1");
                continue;
            }
            StringBuilder tmp = new StringBuilder();
            int count = 0, j = 0;
            for (;j < result.length() - 1;j++) {
                if (result.charAt(j) != result.charAt(j + 1)) {
                    if (count == 0) {
                        tmp.append("1").append(result.charAt(j));
                    }
                    else {
                        tmp.append(String.valueOf(count + 1)).append(result.charAt(j));
                        count = 0;
                    }
                }
                else {
                    count++;
                }
            }
            if (count != 0) {
                tmp.append(String.valueOf(count + 1)).append(result.charAt(j));
            }
            else {
                tmp.append("1").append(result.charAt(j));
            }
            result = tmp;
        }

        return result.toString();
    }
}
