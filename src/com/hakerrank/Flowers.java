package com.hakerrank;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author Anatoly Chernysh
 */
public class Flowers {

    public static void main(String []args)  {
        Scanner in = new Scanner(System.in);

        int amountFlowers, amountFriends;
        amountFlowers = in.nextInt();
        amountFriends = in.nextInt();

        Integer flowerPrices[] = new Integer[amountFlowers];
        for(int i=0; i < amountFlowers; i++){
            flowerPrices[i] = in.nextInt();
        }
        Arrays.sort(flowerPrices, Collections.reverseOrder());

        int result = 0;
        int buyIteration = 1;
        int countFlowers = 0;

        while(true) {

            for (int i = 0; i < amountFlowers; i++) {
                if (i / amountFriends >= buyIteration) {
                    buyIteration++;
                }

                result += flowerPrices[i] * buyIteration;
                countFlowers++;
                if (countFlowers == amountFlowers) {
                    break;
                }
            }

            if (countFlowers == amountFlowers) {
                break;
            }

        }

        System.out.println( result );
    }
}