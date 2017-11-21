package com.amazon.onsite;

/**
 * https://crackinterviewtoday.wordpress.com/2010/03/05/count-the-number-of-occurrences-of-a-element-in-a-sorted-array/
 *
 * @author Anatoly Chernysh
 */
public class CountNumberOfOccurrences {

    public static void main(String[] args) {
        int data[] = {1, 2, 3, 3, 3, 4, 5, 10};
        //System.out.println("Count target number in array: " + binarySearch(data, 0, data.length, 5));
        System.out.println("Count target number in array: " + countNumberOfOccurrences(data, 0, data.length, 3));
    }

    public static int binarySearch(int arr[], int left, int right, int target) {
        if (left <= right) {
            int middle = left + (right - left) / 2;
            if (arr[middle] == target) {
                return middle;
            }

            if (target > arr[middle]) {
                return binarySearch(arr, middle + 1, right, target);
            }

            return binarySearch(arr, left, middle - 1, target);
        }

        return -1;
    }

    public static int countNumberOfOccurrences(int arr[], int left, int right, int target) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        if (left <= right) {
            int firstOccurrence = binarySearchFirstOccurrence(arr, left, right, target);
            int lastOccurrence = binarySearchLastOccurrence(arr, left, right, target);

            if (firstOccurrence == -1 && lastOccurrence == -1) {
                return 0;
            }
            else if (firstOccurrence == lastOccurrence) {
                return 1;
            }
            return lastOccurrence - firstOccurrence + 1;
        }

        return -1;
    }

    public static int binarySearchFirstOccurrence(int arr[], int left, int right, int target) {
        if (left <= right) {
            int middle = (left + right) / 2;
            if ((middle == 0 && arr[middle] == target) || (arr[middle] == target && arr[middle - 1] < target)) {
                return middle;
            }
            else if (arr[middle] >= target) {
                return binarySearchFirstOccurrence(arr, left, middle - 1, target);
            }
            else {
                return binarySearchFirstOccurrence(arr, middle + 1, right, target);
            }
        }
        return -1;
    }

    public static int binarySearchLastOccurrence(int arr[], int left, int right, int target) {
        if (left <= right) {
            int middle = (left + right) / 2;
            if ((middle == arr.length - 1 && arr[middle] == target) || (arr[middle] == target && arr[middle + 1] > target)) {
                return middle;
            }
            else if (arr[middle] <= target) {
                return binarySearchLastOccurrence(arr, middle + 1, right, target);
            }
            else {
                return binarySearchFirstOccurrence(arr, left, middle - 1, target);
            }
        }
        return -1;
    }
}
