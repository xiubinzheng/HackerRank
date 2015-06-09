package com.hakerrank;

import java.util.Scanner;

/**
 * @author Anatoly Chernysh
 */
public class MaximizingXOR {

    static int maxXor(int l, int r) {
        int maxXor = Integer.MIN_VALUE;

        for (int i = l;i <= r;i++) {
            for (int j = l;j <= r;j++) {
                int xor = i ^ j;
                if (xor > maxXor) {
                    maxXor = xor;
                }
            }
        }

        return maxXor;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;
        int _l;
        _l = Integer.parseInt(in.nextLine());

        int _r;
        _r = Integer.parseInt(in.nextLine());

        res = maxXor(_l, _r);
        System.out.println(res);
    }
}
