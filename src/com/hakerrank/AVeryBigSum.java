package com.hakerrank;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author Anatoly Chernysh
 */
public class AVeryBigSum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        BigInteger[] arr = new BigInteger[n];
        for(int i = 0;i < n;i++){
            arr[i] = in.nextBigInteger();
        }

        BigInteger sum = arr[0];
        for (int i = 1;i < arr.length;i++) {
            sum = sum.add(arr[i]);
        }

        System.out.println(sum.toString());

    }
}
