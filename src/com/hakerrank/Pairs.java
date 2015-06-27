package com.hakerrank;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Anatoly Chernysh
 */
public class Pairs {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();

        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            set.add(in.nextInt());
        }


        System.out.println(findPairs(set, k));
    }

    private static int findPairs(Set<Integer> set, int k) {
        int pairs = 0;
        for(Integer i: set){
            pairs += set.contains(i+k) ? 1:0;
        }
        return pairs;
    }

}
