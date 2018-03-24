package com.leetcode;

/**
 * @author Anatoly Chernysh
 */
public class RemoveElement extends Base {

    public static void main(String[] args) {
        //int []nums = {3, 2, 2, 3};
        //int []nums = {4, 5, 1, 8, 3, 1, 0, 6, 3};
        //int []nums = {3, 1, 3, 3};
        //int []nums = {3, 2, 2, 3};
        int []nums = {2};

        RemoveElement removeElement = new RemoveElement();
        System.out.println(removeElement.removeElement(nums, 3));
        dump(nums);
    }

    public int removeElement(int[] nums, int val) {
        int swapIndex = nums.length - 1;

        for (int i = 0;i < nums.length;i++) {
            if (swapIndex <= i) {
                break;
            }
            if (nums[i] == val) {
                if (nums[swapIndex] == val) {
                    for (int j = swapIndex;j > i;j--) {
                        if (nums[j] != val) {
                            swapIndex = j;
                            break;
                        }
                    }
                    if (nums[swapIndex] == val) {
                        break;
                    }
                }
                swap(nums, swapIndex--, i);
            }
        }

        for (int i = 0;i < nums.length;i++) {
            if (nums[i] == val) {
                return i;
            }
        }
        return nums.length;
    }

    public void swap(int []nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
