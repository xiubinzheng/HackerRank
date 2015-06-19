package com.hakerrank;

import java.util.Scanner;

/**
 * @author Anatoly Chernysh
 */
public class InsertionSortPart1 {

    public static void main(String []args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i < n;i++){
            arr[i] = in.nextInt();
        }
        insertion(arr);
    }

    public static void insertion(int []arr) {
        int temp = arr[arr.length - 1];

        if (arr.length == 1) {
            printArray(arr, 0, arr.length);
            return;
        }

        if (arr.length == 2) {
            if (arr[0] > arr[1]) {
                arr[1] = arr[0];
                arr[0] = temp;
            }
            printArray(arr, 0, arr.length);
            return;
        }

        for (int i = arr.length - 2;i >= 0;i--) {
            if (arr[i] >= temp) {
                arr[i + 1] = arr[i];
            }
            else {
                arr[i + 1] = temp;
                printArray(arr, 0, arr.length);
                break;
            }
            printArray(arr, 0, arr.length);
        }

        if (arr[0] > temp) {
            arr[0] = temp;
            printArray(arr, 0, arr.length);
        }
    }

    static void printArray(int[] arr, int l, int r) {
        for(int i = l;i < r;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }

}
