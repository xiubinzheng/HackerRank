package com.hakerrank;

import java.util.Scanner;

/**
 * @author Anatoly Chernysh
 */
public class Staircase {

    public static void main(String []args) {
        Scanner in = new Scanner(System.in);
        int height = in.nextInt();
        drawStaircase(height);
    }

    public static void drawStaircase(int height) {
        for (int i = 0;i < height;i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = height - 2;j >= 0;j--) {
                if (j < i) {
                    sb.append("#");
                }
                else {
                    sb.append(" ");
                }
            }
            sb.append("#");
            System.out.println(sb.toString());
        }
    }
}
