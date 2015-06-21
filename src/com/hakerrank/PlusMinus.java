package com.hakerrank;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @author Anatoly Chernysh
 */
public class PlusMinus {


    public static void main(String []args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int countPositive = 0;
        int countNegative = 0;
        int countZero = 0;

        for(int i = 0;i < n;i++){
            int value = in.nextInt();
            if (value > 0) {
                countPositive++;
            }
            else if (value < 0) {
                countNegative++;
            }
            else {
                countZero++;
            }
        }

        DecimalFormat myFormatter = new DecimalFormat("0.000");

        System.out.println(myFormatter.format((double)countPositive / n));
        System.out.println(myFormatter.format((double)countNegative / n));
        System.out.println(myFormatter.format((double)countZero / n));

    }

}
