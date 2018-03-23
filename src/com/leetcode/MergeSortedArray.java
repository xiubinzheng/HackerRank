package com.leetcode;

/**
 * @author Anatoly Chernysh
 */
public class MergeSortedArray {

    public static void main(String[] args) {
        //int []arr1 = {1, 5, 8, 20, 0, 0, 0};
        //int []arr2 = {3, 6, 11};
        int []arr1 = {2, 0};
        int []arr2 = {1};

        mergeSortedArrays(arr1, 1, arr2, 1);
        for (int i = 0;i < arr1.length;i++) {
            System.out.print(arr1[i] + " ");
        }
    }

    public static void mergeSortedArrays(int[] nums1, int m, int[] nums2, int n) {
        for (int j = 0;j < nums2.length;j++) {
            nums1[nums1.length - nums2.length + j] = nums2[j];
            for (int i = nums1.length - nums2.length + j; i > 0; i--) {
                if (nums1[i] < nums1[i - 1]) {
                    int temp = nums1[i];
                    nums1[i] = nums1[i - 1];
                    nums1[i - 1] = temp;
                }
            }
        }
    }
}
