package com.hakerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author Anatoly Chernysh
 */
public class MinMax {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());
        int K = Integer.parseInt(in.readLine());

        int[] list = new int[N];

        for(int i = 0; i < N; i ++) {
            list[i] = Integer.parseInt(in.readLine());
        }

        Arrays.sort(list);

        int unfairness = Integer.MAX_VALUE;

        for (int i = 0;i <= N - K;i++) {
            int min = list[i];
            int max = list[i + K - 1];
            if (max - min < unfairness) {
                unfairness = max - min;
            }
        }

        System.out.println(unfairness);
    }
}
