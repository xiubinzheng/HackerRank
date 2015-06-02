package com.hakerrank;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author Anatoly Chernysh
 */
public class JavaBigInteger {

    public static void main(String []args) {
        Scanner in = new Scanner(System.in);

        BigInteger a = new BigInteger(in.nextLine());
        BigInteger b = new BigInteger(in.nextLine());

        System.out.println(a.add(b).toString());
        System.out.println(a.multiply(b).toString());
    }
}
