package com.hakerrank;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author Anatoly Chernysh
 */
public class TaumAndBday {

    public static void main(String []args) {

        Scanner in = new Scanner(System.in);
        int amountTestCases = in.nextInt();

        for (int i = 0;i < amountTestCases;i++) {
            int countWhitePresents = in.nextInt();
            int countBlackPresents = in.nextInt();

            int whitePresentCost = in.nextInt();
            int blackPresentCost = in.nextInt();
            int convertingFee = in.nextInt();

            BigInteger bestBlackCost = new BigInteger("" + Math.min(blackPresentCost, whitePresentCost + convertingFee));

            BigInteger bestWhiteCost = new BigInteger("" + Math.min(whitePresentCost, blackPresentCost+ convertingFee));

            BigInteger total = bestBlackCost.multiply(new BigInteger(countBlackPresents + "")).add(bestWhiteCost.multiply(new BigInteger(countWhitePresents + "")));
            System.out.println(total.toString());
        }
    }


}
