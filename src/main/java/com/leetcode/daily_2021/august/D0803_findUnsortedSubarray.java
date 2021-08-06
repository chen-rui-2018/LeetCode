package com.leetcode.daily_2021.august;

import java.util.Arrays;

/**
 * @author： chenr
 * @date： Created on 2021/8/3 16:09
 * @version： v1.0
 * @modified By:
 */
public class D0803_findUnsortedSubarray {
    public static void main(String[] args) {
        int[] nums = {2, 6, 4, 8, 10, 9, 15};
        int unsortedSubarray = new D0803_findUnsortedSubarray().findUnsortedSubarray(nums);
        System.out.println(unsortedSubarray);
    }

    public int findUnsortedSubarray1(int[] nums) {
        if (isSorted(nums)) {
            return 0;
        }
        int[] sortNums = new int[nums.length];
        System.arraycopy(nums, 0, sortNums, 0, nums.length);
        Arrays.sort(sortNums);
        int left = 0, right = nums.length - 1;
        while (nums[left] == sortNums[left]) {
            left++;
        }
        while (nums[right] == sortNums[right]) {
            right--;
        }
        return right - left + 1;
    }

    public boolean isSorted(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int maxn = Integer.MIN_VALUE, right = -1;
        int minn = Integer.MAX_VALUE, left = -1;
        for (int i = 0; i < n; i++) {
            if (maxn > nums[i]) {
                right = i;
            } else {
                maxn = nums[i];
            }
            if (minn < nums[n - i - 1]) {
                left = n - i - 1;
            } else {
                minn = nums[n - i - 1];
            }
        }
        return right == -1 ? 0 : right - left + 1;
    }
}
