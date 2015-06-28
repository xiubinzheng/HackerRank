package com.hakerrank;

import java.util.Scanner;

/**
 * @author Anatoly Chernysh
 */
public class SongOfPi {

    public static final String PI = "31415926535897932384626433833";

    public static void main(String []args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.valueOf(in.nextLine());
        for(int i = 0;i < n;i++){
            String string = in.nextLine();
            System.out.println(isSongPI(string) ? "It's a pi song." : "It's not a pi song.");
        }
    }

    public static boolean isSongPI(String string) {
        StringBuffer piString = new StringBuffer();

        string = string.replaceAll("[^A-Za-z ]", "");
        String []words = string.split(" ");
        for (String word : words) {
            piString.append(word.length());
        }

        return PI.startsWith(piString.toString());
    }
}
