package com.hakerrank;

import java.util.Scanner;

/**
 * @author Anatoly Chernysh
 */
public class FindHackerRank {

    public static final String HACKERRANK = "hackerrank";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.valueOf(in.nextLine());

        for (int i = 0;i < n;i++) {
            String line = in.nextLine();

            boolean starts = line.startsWith(HACKERRANK);
            boolean ends = line.endsWith(HACKERRANK);

            if (starts && ends) {
                System.out.println(0);
            }
            else if (starts && !ends) {
                System.out.println(1);
            }
            else if (!starts && ends) {
                System.out.println(2);
            }
            else {
                System.out.println(-1);
            }
        }
    }

}
