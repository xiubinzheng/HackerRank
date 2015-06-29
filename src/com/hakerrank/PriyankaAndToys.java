package com.hakerrank;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Anatoly Chernysh
 */
public class PriyankaAndToys {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] weightOfToys = new int[n];
        for(int i = 0;i < n;i++){
            weightOfToys[i] = in.nextInt();
        }

        Arrays.sort(weightOfToys);

        int minimumPrice = 0;
        for (int i = 0;i < weightOfToys.length;) {
            int current = weightOfToys[i];
            int currentPrice = 0;
            for (int j = i;j < weightOfToys.length;j++) {
                if (current + 4 < weightOfToys[j]) {
                    break;
                }
                else {
                    currentPrice++;
                }
            }
            if (currentPrice == 1) {
                i++;
            }
            else {
                i += currentPrice;
            }
            minimumPrice++;
        }

        System.out.println(minimumPrice);
    }
}