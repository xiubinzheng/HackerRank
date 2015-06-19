package com.hakerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Anatoly Chernysh
 */
public class Quicksort1Partition {

    static void partition(int[] ar) {
        int pivot = ar[0];

        List<Integer> leftToPivot = new ArrayList<Integer>();
        List<Integer> rightToPivot = new ArrayList<Integer>();

        for (int i = 1;i < ar.length;i++) {
            if (ar[i] > pivot) {
                rightToPivot.add(ar[i]);
            }
            else {
                leftToPivot.add(ar[i]);
            }
        }

        leftToPivot.add(pivot);

        leftToPivot.addAll(rightToPivot);
        printArray(leftToPivot.toArray(new Integer[0]));
    }

    static void printArray(Integer[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i < n;i++){
            arr[i] = in.nextInt();
        }
        partition(arr);
    }

}
