package com.leetcode;

/**
 * @author Anatoly Chernysh
 */
public class CountPrimes {

    public static void main(String[] args) {
        System.out.println(countPrimes(999983));
    }

    /*
    public static int countPrimes(int n) {
        if (n == 0 || n == 1) {
            return 0;
        }
        int nonPrimeCount = 2;
        boolean []primes = new boolean[n];
        for (int i = 0;i < n;i++) {
            primes[i] = true;
        }

        for (int i = 2;i < n;i++) {
            if (primes[i]) {
                for (int j = i; j < n; j++) {
                    if (primes[j]) {
                        if (j % i == 0 && j != i) {
                            primes[j] = false;
                            nonPrimeCount++;
                        }
                    }
                }
            }
        }

        return n - nonPrimeCount;
    }
    */

    public static int countPrimes(int n) {
        if (n == 0 || n == 1) {
            return 0;
        }

        boolean []primes = new boolean[n];
        for (int i = 0;i < n;i++) {
            primes[i] = true;
        }

        for (int i = 2;i < Math.sqrt(n);i++) {
            if (primes[i]) {
                for (int j = i * i; j < n; j += i) {
                    primes[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2;i < n;i++) {
            if (primes[i]) {
                count++;
            }
        }

        return count;
    }

}
