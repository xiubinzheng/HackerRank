package com.hakerrank;

import java.util.Scanner;

/**
 * @author Anatoly Chernysh
 */
public class AlternatingCharacters {

    public static void main(String []args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        for(int i = 0;i < n;i++){
            String str = in.nextLine();
            System.out.println(countAlternatingCharacters(str));
        }
    }

    public static int countAlternatingCharacters(String str) {
        int countRemoved = 0;

        char current = str.charAt(0);
        for (int i = 1;i < str.length();i++) {
            if (current == str.charAt(i)) {
                countRemoved++;
            }
            else {
                current = str.charAt(i);
            }
        }

        return countRemoved;
    }
}
