package com.hakerrank;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Anatoly Chernysh
 */
public class MarkAndToys {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt(), k = stdin.nextInt();

        int prices[] = new int[n];

        for(int i = 0;i < n;i++) {
            prices[i] = stdin.nextInt();
        }

        Arrays.sort(prices);

        int answer = 0;

        for (int i = 0;i < prices.length;i++) {
            if (k - prices[i] >= 0) {
                k -= prices[i];
                answer++;
            }
            else {
                break;
            }
        }

        // Compute the final answer from n,k,prices
        System.out.println(answer);
    }
}
