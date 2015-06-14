package com.hakerrank;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Anatoly Chernysh
 */
public class Anagram {

    public static void main(String []args) {
        Scanner in = new Scanner(System.in);
        int amountTestCases = Integer.parseInt(in.nextLine());

        for (int j = 0;j < amountTestCases;j++) {
            String strings = in.nextLine();

            if (strings.length() % 2 != 0) {
                System.out.println(-1);
                continue;
            }

            String s1  = strings.substring(0, strings.length() / 2);
            s1 = s1.trim().toLowerCase();

            String s2 = strings.substring(strings.length() / 2, strings.length());
            s2 = s2.trim().toLowerCase();

            int []s1Alphabet = new int[26];
            Arrays.fill(s1Alphabet, 0);

            for (int i = 0;i < s1.length();i++) {
                char ch = s1.charAt(i);
                int index = (int)ch - 97;
                if (index >= 0 && index <= 25) {
                    s1Alphabet[index] += 1;
                }
            }

            for (int i = 0;i < s2.length();i++) {
                char ch = s2.charAt(i);
                int index = (int)ch - 97;
                if (index >= 0 && index <= 25 && s1Alphabet[index] > 0) {
                    s1Alphabet[index] -= 1;
                }
            }

            int count = 0;
            for (int i = 0;i < s1Alphabet.length;i++) {
                if (s1Alphabet[i] > 0) {
                    count += s1Alphabet[i];
                }
            }

            System.out.println(count);
        }
    }
}
