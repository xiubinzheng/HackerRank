package com.codility;

/**
 * @author Anatoly Chernysh
 */
public class CountSemiprimes {

    public static void main(String []args) {
        solution(26, new int [] {1, 4, 16}, new int [] {26, 10, 20});
    }

    public static int[] solution(int N, int[] P, int[] Q) {
        boolean []notPrimes = findNotPrimes(N);
        boolean []semiPrimes = findSemiPrimes(N, notPrimes);
        int []result = new int[P.length];

        int []sum = new int[N + 1];
        int index = 0;
        for (int i = 1; i <= N; i++) {
            sum[i] = sum[i - 1] + (semiPrimes[i] ? 1 : 0);
            while (index < Q.length && i >= Q[index]) {
                result[index] = sum[Q[index]] - sum[P[index] - 1];
                index++;
            }
        }

        return result;
    }

    public static boolean[] findNotPrimes(int N) {
        boolean []notPrimes = new boolean[N + 1];

        notPrimes[0] = true;
        notPrimes[1] = true;

        int i = 2;
        while (i * i <= N) {
            if (!notPrimes[i]) {
                int k = i * i;
                while (k <= N) {
                    notPrimes[k] = true;
                    k += i;
                }
            }
            i++;
        }
        return notPrimes;
    }

    public static boolean[] findSemiPrimes(int N, boolean []notPrimes) {
        boolean []semiPrimes = new boolean[N + 1];
        for (int i = 2;i * i <= N;i++) {
            if (!notPrimes[i]) {
                semiPrimes [i * i] = true;
                for (int k = i * (i + 1);k <= N;k += i) {
                    if (!notPrimes[k / i]) {
                        semiPrimes[k] = true;
                    }
                }
            }
        }
        return semiPrimes;
    }
}
