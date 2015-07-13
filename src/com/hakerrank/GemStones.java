package com.hakerrank;

import java.util.Scanner;

/**
 * @author Anatoly Chernysh
 */
public class GemStones {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int amountOfTestCases = Integer.valueOf(in.nextLine());

        int []gems = new int[27];

        for(int i = 0;i < amountOfTestCases;i++) {
            String rock = in.nextLine();

            StringBuffer uniqueGems = new StringBuffer();

            for (int j = 0;j < rock.length();j++) {
                char gem = rock.charAt(j);
                if (uniqueGems.indexOf(String.valueOf(gem)) == -1) {
                    gems[(int) gem - 97]++;
                    uniqueGems = uniqueGems.append(gem);
                }
            }
        }

        int amountOfGems = 0;
        for (int i = 0;i < gems.length;i++) {
            if (gems[i] >= amountOfTestCases) {
                amountOfGems++;
            }
        }
        System.out.println(amountOfGems);
    }
}
