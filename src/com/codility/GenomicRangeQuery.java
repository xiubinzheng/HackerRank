package com.codility;

/**
 * @author Anatoly Chernysh
 */
public class GenomicRangeQuery {

    public static void main(String[] args) {
        String S = "CAGCCTA";
        int []P = {2, 5, 0};
        int []Q = {4, 5, 6};

        /*
        String S = "TC";
        int []P = {0, 0, 1};
        int []Q = {0, 1, 1};
        */


        int []result = solutionEx(S, P, Q);
        for (int i = 0;i < result.length;i++) {
            System.out.println(result[i]);
        }
    }

    public static int[] solution(String S, int[] P, int[] Q) {
        int []result = new int[P.length];

        for (int i = 0;i < P.length;i++) {
            int startIdx = P[i];
            int endIdx = Q[i];

            int min = S.charAt(startIdx);
            for (int j = startIdx;j <= endIdx;j++) {
                int value = S.charAt(j);
                if (value < min) {
                    min = value;
                }
            }

            result[i] = getValue(min);
        }

        return result;
    }

    public static int getValue(int min) {
        if (min == 'A') {
            return 1;
        }
        else if (min == 'C') {
            return 2;
        }
        else if (min == 'G') {
            return 3;
        }
        return 4;
    }

    public static int[] solutionEx(String S, int[] P, int[] Q) {
        int size = (int) (2 * Math.pow(2.0, Math.floor((Math.log((double) S.length()) / Math.log(2.0)) + 1)));
        M = new int[size];

        buildTree(0, 0, S.length() - 1, S);

        int []result = new int[P.length];

        for (int i = 0;i < P.length;i++) {
            int startIdx = P[i];
            int endIdx = Q[i];
            result[i] = getValue(S.charAt(RMQ(0, 0, S.length() - 1, startIdx, endIdx, S)));
        }

        return result;
     }

    public static int M[];

    static void buildTree(int node, int start, int end, String A){
        if(start == end) {
            M[node] = start;
        }
        else {
            buildTree(2 * node + 1, start, (start + end) / 2, A);
            buildTree(2 * node + 2, (start + end) / 2 + 1, end, A);

            int value1 = getValue(A.charAt(M[2 * node + 1]));
            int value2 = getValue(A.charAt(M[2 * node + 2]));

            if(value1 < value2) {
                M[node] = M[2 * node + 1];
            }
            else {
                M[node] = M[2 * node + 2];
            }
        }
    }

    static int RMQ(int node,int start,int end,int s,int e,String A){
        if(s <= start & e >= end) {
            return M[node];
        }
        else if( s > end || e < start) {
            return -1;
        }

        int q1 = RMQ(2 * node + 1,start,(start + end) / 2,s, e, A);
        int q2 = RMQ(2 * node + 2, (start + end) / 2 + 1, end, s, e, A);

        if(q1 == -1) {
            return q2;
        }
        else if(q2 == -1) {
            return q1;
        }

        int value1 = getValue(A.charAt(q1));
        int value2 = getValue(A.charAt(q2));

        if(value1 < value2) {
            return q1;
        }
        return q2;
    }
}