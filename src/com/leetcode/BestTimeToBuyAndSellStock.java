package com.leetcode;

/**
 * @author Anatoly Chernysh
 */
public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        //int[] prices = {0, 20, 8, 7, 30};
        //int []prices = {2,1};
        //int []prices = {1, 2, 4};
        int []prices = {2,1,2,0,1};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int sum = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                sum += (prices[i + 1] - prices[i]);
            }

        }

        return sum;
    }
}
