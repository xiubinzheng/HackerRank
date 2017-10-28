package com.algorithms;

/**
 * @author Anatoly Chernysh
 */
public class QuickSort {

    public static void main(String[] args) {
        int data[] = {7, 2, 1, 6, 8, 5, 3, 4};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(data, 0, data.length);
        System.out.println();
    }

    public void quickSort(int []array, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int partitioningIndex = partitioning(array, startIndex, endIndex);
            quickSort(array, startIndex, partitioningIndex - 1);
            quickSort(array, partitioningIndex + 1, endIndex);
        }
    }

    public int partitioning(int []array, int startIndex, int endIndex) {
        int pivot = array[endIndex - 1], partitioningIndex = startIndex;

        for (int i = startIndex;i < endIndex - 1;i++) {
            if (array[i] < pivot) {
                swap(array, i, partitioningIndex);
                partitioningIndex++;
            }
        }
        swap(array, endIndex - 1, partitioningIndex);

        return partitioningIndex;
    }

    public void swap(int []array, int from, int to) {
        int temp = array[to];
        array[to] = array[from];
        array[from] = temp;
    }

}
