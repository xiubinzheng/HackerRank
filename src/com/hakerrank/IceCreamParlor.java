package com.hakerrank;

import java.util.Scanner;

/**
 * @author Anatoly Chernysh
 */
public class IceCreamParlor {
    public static class Task {

        public int sum;

        public int []prices;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int amountTestCases = Integer.parseInt(in.nextLine());

        Task []tasks = new Task[amountTestCases];

        for (int i = 0;i < amountTestCases;i++) {
            int sum = Integer.parseInt(in.nextLine());
            int amountOfPrices = Integer.parseInt(in.nextLine());

            tasks[i] = new IceCreamParlor.Task();
            tasks[i].sum = sum;
            tasks[i].prices = prepareArray(in.nextLine(), amountOfPrices);
        }

        for (Task task : tasks) {
            solution(task.sum, task.prices);
        }
    }

    public static void solution(int sum, int []prices) {
        for (int i = 0;i < prices.length;i++) {
            for (int j = i + 1;j < prices.length;j++) {
                if (prices[i] + prices[j] == sum) {
                    System.out.println((i + 1) + " " + (j + 1));
                }
            }
        }
    }

    public static int[] prepareArray(String input, int size) {
        String[] input_split = input.split(" ");
        int []arr = new int[size];

        for(int i = 0; i < size; i++) {
            arr[i] =  Integer.parseInt(input_split[i]);
        }

        return arr;
    }

}
