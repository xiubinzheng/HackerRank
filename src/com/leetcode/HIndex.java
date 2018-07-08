package com.leetcode;

import java.util.Arrays;

/**
 * @author Anatoly Chernysh
 */
public class HIndex {

    public static void main(String[] args) {
        //int []citations = {3,0,6,1,5}; // 3
        //int []citations = {0,0}; // 0
        //int []citations = {100}; // 1
        //int []citations = {0, 1}; // 1
        //int []citations = {1, 2}; // 1
        int []citations = {4, 8, 3, 10, 5}; // 4
        //int []citations = {11, 15}; // 2
        System.out.println(hIndex(citations));
    }


    public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        int totalCitations = citations.length;
        int hIndex = 0;

        for (int references : citations) {
            if (references >= totalCitations && totalCitations > hIndex) {
                hIndex = totalCitations;
            }
            totalCitations--;
        }

        return hIndex;
    }

}
