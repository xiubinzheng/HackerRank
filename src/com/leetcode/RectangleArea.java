package com.leetcode;

/**
 * @author Anatoly Chernysh
 */
public class RectangleArea {

    public static void main(String[] args) {
        //System.out.println(computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
        //System.out.println(computeArea(0, 0, 0, 0, -1, -1, 1, 1));
        //System.out.println(computeArea(-2, -2, 2, 2, 3, 3, 4, 4));
        //System.out.println(computeArea(-2, -2, 2, 2, -4, 3, -3, 4));
        //System.out.println(computeArea(-2, -2, 2, 2, -1, -1, 1, 1)); // 16
        //System.out.println(computeArea(-2, -2, 2, 2, -3, 2, -2, 3)); // 17
        //System.out.println(computeArea(-2, -2, 2, 2, -2, 2, 2, 4)); // 24
        //System.out.println(computeArea(-2, -2, 2, 2, 1, 1, 3, 3)); // 19
        System.out.println(computeArea(-1500000001, 0, -1500000000, 1, 1500000000, 0, 1500000001, 1)); // 2
    }

    public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        long rec1Area = (C - A) * (D - B);
        long rec2Area = (G - E) * (H - F);
        long intLength = (long)Math.min(C, G) - (long)Math.max(A, E);
        long intWidth = (long)Math.min(D, H) - (long)Math.max(B, F);
        long intArea = (intLength > 0 ? intLength : 0l) * (intWidth > 0 ? intWidth : 0l);
        return (int)(rec1Area + rec2Area - intArea);
    }
}
