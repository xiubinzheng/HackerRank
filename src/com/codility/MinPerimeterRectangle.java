package com.codility;

/**
 * @author Anatoly Chernysh
 */
public class MinPerimeterRectangle {

    public static int solution(int N) {

        if (N == 1) {
            return 2 * (1 + 1);
        }

        long minP = Long.MAX_VALUE;

        long i = 1;
        while (i * i <= N) {
            if (N % i == 0) {
                long A = i;
                long B = N / A;
                long P = 2 * (A + B);
                if (P < minP) {
                    minP = P;
                }
            }
            i++;
        }

        return (int)minP;
    }

    public static void main(String[] args) {
        System.out.println(solution(36));
    }

}
