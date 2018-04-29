package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anatoly Chernysh
 */
public class ZigZagConversion {

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 4;

        //String s = "PAYPALISHIRING";
        //int numRows = 7;

        //String s = "ABCD";
        //int numRows = 2;


        System.out.println(convert(s, numRows));
    }

    public static String convert(String s, int numRows) {
        if ("".equals(s)) {
            return s;
        }

        List<String> zigZag = new ArrayList<>();
        int amountZigZagColumns = numRows - 2;
        int zigZagCount = 0;
        boolean isZigZagColumn = false;

        for (int i = 0;i < s.length();) {
            StringBuilder row = new StringBuilder();

            int j = i, rowSize = j + numRows, zigZagIndex = numRows - zigZagCount + i - 2;
            for (;j < rowSize;j++) {
                if (isZigZagColumn) {
                    if (zigZagIndex == j) {
                        row.append(s.charAt(i++));
                    }
                    else {
                        row.append(0);
                    }
                }
                else {
                    row.append(s.charAt(i++));
                }

                if (i > s.length() - 1) {
                    if (row.length() < numRows) {
                        int missingSize = numRows - row.length();
                        for (int k = 0;k <= missingSize;k++) {
                            row.append(0);
                        }
                    }
                    break;
                }

            }
            zigZag.add(row.toString());

            if (isZigZagColumn) {
                zigZagCount++;
            }

            if ((isZigZagColumn && zigZagCount >= amountZigZagColumns) || amountZigZagColumns == 0) {
                isZigZagColumn = false;
                zigZagCount = 0;
            }
            else {
                isZigZagColumn = true;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0;i < zigZag.get(0).length();i++) {
            for (int j = 0;j < zigZag.size();j++) {
                char ch = zigZag.get(j).charAt(i);
                if (ch != '0') {
                    result.append(ch);
                }
            }
        }
        return result.toString();
    }
}
