package com.hakerrank;

import java.util.Scanner;

/**
 * @author Anatoly Chernysh
 */
public class IntroToTutorialChallenges {


    public static void main(String []args) {
        Scanner in = new Scanner(System.in);

        int value = in.nextInt();
        int size = in.nextInt();
        int index = 0;

        int[] arr = new int[size];
        for(int i = 0;i < size;i++){
            arr[i] = in.nextInt();
            if (arr[i] == value) {
                index = i;
            }
        }

        System.out.println(index);
    }

}
