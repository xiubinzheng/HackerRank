package com.hakerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Anatoly Chernysh
 */
public class LexicographicallySmallestAndLargestSubstring {

    public static void main(String []args) {
        Scanner in = new Scanner(System.in);
        String string = in.nextLine();
        int length = in.nextInt();

        List<String> subStrings = generateSubStrings(string, length);
        String[] sortedSubStrings = sortSubStrings(subStrings);

        System.out.println(sortedSubStrings[0]);
        System.out.println(sortedSubStrings[sortedSubStrings.length - 1]);
    }

    private static List<String> generateSubStrings(String string, int subStringLength) {
        List<String> subStrings = new ArrayList<String>();
        for (int i = 0;i < subStringLength;i++) {
            for (int j = i;j + subStringLength <= string.length();j += subStringLength) {
                String subString = string.substring(j, j + subStringLength);
                subStrings.add(subString);
            }
        }

        return subStrings;
    }

    private static String[] sortSubStrings(List<String> subStrings) {
        String []sortedSubStrings = subStrings.toArray(new String[0]);
        Arrays.sort(sortedSubStrings);
        return sortedSubStrings;
    }
}
