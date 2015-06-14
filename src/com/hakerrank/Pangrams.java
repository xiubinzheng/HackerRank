package com.hakerrank;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Anatoly Chernysh
 */
public class Pangrams {

    public static void main(String []args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        s = s.toLowerCase();

        int []alphabet = new int[26];
        Arrays.fill(alphabet, 0);

        for (int i = 0;i < s.length();i++) {
            char ch = s.charAt(i);
            if (ch != ' ') {
                int index = (int)s.charAt(i) - 97;
                if (index >= 0 && index <= 25) {
                    alphabet[index] = 1;
                }
            }
        }

        for (int i = 0;i < alphabet.length;i++) {
            if (alphabet[i] == 0) {
                System.out.println("not pangram");
                return;
            }
        }

        System.out.println("pangram");

    }
}
