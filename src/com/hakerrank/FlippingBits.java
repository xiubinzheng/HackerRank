package com.hakerrank;

import java.util.Scanner;

/**
 * @author Anatoly Chernysh
 */
public class FlippingBits {

    public static void main(String []args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0;i < n;i++){
            long value = in.nextLong();

            long flippedValue = value ^ 0xFFFFFFFF;

            long unsignedValue = flippedValue & 0xffffffffl;
            System.out.println(unsignedValue);
        }
    }
}
