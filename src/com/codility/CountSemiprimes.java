package com.codility;

import java.util.Arrays;

/**
 * @author Anatoly Chernysh
 */
public class CountSemiprimes {

    public static void main(String []args) {
        System.out.println(factorization(26, factorizations(26)));
    }

    public static int[] solution(int N, int[] P, int[] Q) {
        return null;
    }

    public static void findPrimes(int N) {
        boolean []sieve = new boolean[N + 1];
        Arrays.fill(sieve, true);

        sieve[0] = false;
        sieve[1] = false;

        int i = 2;
        while (i * i <= N) {
            if (sieve[i]) {
                int k = i * i;
                while (k <= N) {
                    sieve[k] = false;
                    k += i;
                }
            }
            i++;
        }

        print(sieve);
    }

    public static int[] factorizations(int N) {
        int []factorizations = new int[N + 1];
        Arrays.fill(factorizations, 0);

        int i = 2;
        while (i * i <= N) {
            if (factorizations[i] == 0) {
                int k = i * i;
                while (k <= N) {
                    if (factorizations[i] == 0) {
                        factorizations[k] = i;
                    }
                    k += i;
                }
            }
            i++;
        }

        print(factorizations);
        return factorizations;
    }

    public static int factorization(int x, int []factorizations) {
        int primeFactors = 0;
        while (factorizations[x] > 0) {
            primeFactors += factorizations[x];
            x = x / factorizations[x];
        }
        primeFactors += x;
        return primeFactors;
    }

    public static void print(boolean []sieve) {
        for (int i = 0;i < sieve.length;i++) {
            if (sieve[i]) {
                System.out.print(i + " ");
            }
        }
    }

    public static void print(int []factorizations) {
        for (int i = 0;i < factorizations.length;i++) {
            System.out.print(i + "=" + factorizations[i] + " ");
        }
    }
}
