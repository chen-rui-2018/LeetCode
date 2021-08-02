package com.sort;

import java.util.Arrays;

/**
 * 快速排序
 *
 * @author： chenr
 * @date： Created on 2021/7/20 10:38
 * @version： v1.0
 * @modified By:
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] quickSort = new QuickSort().doQuickSort(arr);
        System.out.println(Arrays.toString(quickSort));
    }

    public int[] doQuickSort(int[] nums) {
        if (nums == null || nums.length <= 1){
            return nums;
        }
        sort(nums, 0, nums.length - 1);

        return nums;
    }

    void sort(int[] nums, int l, int r) {
        if (l < r) {
            int i = l, j = r;
            int x = nums[i];
            while (i < j) {
                while (i < j && nums[j] > x) {
                    j--;
                }
                if (i < j) {
                    nums[i++] = nums[j];
                }
                while (i < j && nums[i] < x) {
                    i++;
                }
                if (i < j) {
                    nums[j--] = nums[i];
                }
            }
            nums[i] = x;
            sort(nums, l, i - 1);
            sort(nums, i + 1, r);
        }

    }
}
