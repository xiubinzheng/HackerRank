package com.algorithms;

/**
 * @author Anatoly Chernysh
 *
 * Worst-case performance	O(n log n)
 * Average performance	O(n log n)
 * Worst-case space complexity	О(n) total, O(n) auxiliary
 */
public class MergeSort {

    public static void main(String[] args) {
        int data[] = {2, 4, 1, 6, 8, 5, 3, 7};
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(data);
        System.out.println();
    }

    public void mergeSort(int []array) {
        if (array.length == 1) {
            return;
        }

        int middle = array.length >> 1;

        int leftArr[] = new int[middle];
        System.arraycopy(array, 0, leftArr, 0, middle);
        mergeSort(leftArr);

        int rightArr[] = new int[array.length - middle];
        System.arraycopy(array, middle, rightArr, 0, rightArr.length);
        mergeSort(rightArr);

        merge(array, leftArr, rightArr);
    }

    public void merge(int []array, int []leftArr, int []rightArr) {
        int leftIndex = 0, rightIndex = 0, index = 0;
        while (leftIndex < leftArr.length && rightIndex < rightArr.length) {
            if (leftArr[leftIndex] < rightArr[rightIndex]) {
                array[index++] = leftArr[leftIndex++];
            }
            else {
                array[index++] = rightArr[rightIndex++];
            }
        }

        while (leftIndex < leftArr.length) {
            array[index++] = leftArr[leftIndex++];
        }

        while (rightIndex < rightArr.length) {
            array[index++] = rightArr[rightIndex++];
        }

    }

}
