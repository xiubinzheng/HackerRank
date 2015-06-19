package com.hakerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Anatoly Chernysh
 */
public class Quicksort2Sorting {

    public static void main(String []args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i < n;i++){
            arr[i] = in.nextInt();
        }

        quickSortWithRespectToOrder(arr, 0, arr.length);
    }

    public static int partition(int []arr, int l, int r) {

        if (r - l == 1) {
            return l;
        }

        int pivotIndex = l;
        int pivotValue = arr[pivotIndex];

        int temp = arr[r - 1];
        arr[r - 1] = pivotValue;
        arr[pivotIndex] = temp;
        pivotIndex = r - 1;

        for (int i = l;i < r;i++) {
            if (arr[i] >= pivotValue && i <= pivotIndex) {
                temp = arr[i];
                arr[i] = pivotValue;
                arr[pivotIndex] = temp;
                pivotIndex = i;
            }
            else if (i > pivotIndex && arr[i] <= pivotValue) {
                temp = arr[i];
                arr[i] = pivotValue;
                arr[pivotIndex] = temp;
                pivotIndex = i;
            }
        }

        return pivotIndex;
    }

    public static void quickSort(int []arr, int l, int r) {
        if (l < r) {
            int p = partition(arr, l, r);
            quickSort(arr, l, p);
            quickSort(arr, p + 1, r);
            printArray(arr, l, r);

        }
    }

    public static int partitionWithRespectToOrder(int []arr, int l, int r) {

        if (r - l == 1) {
            return l;
        }

        int pivotIndex = l;
        int pivotValue = arr[pivotIndex];

        List<Integer> leftToPivot = new ArrayList<Integer>();
        List<Integer> rightToPivot = new ArrayList<Integer>();

        for (int i = l + 1;i < r;i++) {
            if (arr[i] > pivotValue) {
                rightToPivot.add(arr[i]);
            }
            else {
                leftToPivot.add(arr[i]);
            }
        }

        if (!leftToPivot.isEmpty()) {
            pivotIndex = leftToPivot.size() + l;
        }

        leftToPivot.add(pivotValue);
        leftToPivot.addAll(rightToPivot);

        int i = l;
        for (Integer value : leftToPivot) {
            arr[i++] = value.intValue();
        }

        return pivotIndex;
    }

    public static void quickSortWithRespectToOrder(int []arr, int l, int r) {
        if (l < r) {
            int p = partitionWithRespectToOrder(arr, l, r);
            quickSortWithRespectToOrder(arr, l, p);
            quickSortWithRespectToOrder(arr, p + 1, r);
            if (r - l > 1) {
                printArray(arr, l, r);
            }
        }
    }

    static void printArray(int[] arr, int l, int r) {
        for(int i = l;i < r;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }
}