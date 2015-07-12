package com.hakerrank;

import java.util.Scanner;

/**
 * @author Anatoly Chernysh
 */
public class AngryProfessor {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int amountOfTestCases = in.nextInt();

        for (int i = 0;i < amountOfTestCases;i++) {
            int amountOfStudentsInGroup = in.nextInt();
            int minimumAmountOfStudentsInGroup = in.nextInt();

            int countOfStudentsInTime = 0;
            for (int j = 0;j < amountOfStudentsInGroup;j++) {
                countOfStudentsInTime += in.nextInt() <= 0 ? 1 : 0;
            }

            if (countOfStudentsInTime >= minimumAmountOfStudentsInGroup) {
                System.out.println("NO");
            }
            else {
                System.out.println("YES");
            }
        }
    }
}
