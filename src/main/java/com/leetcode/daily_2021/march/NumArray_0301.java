package com.leetcode.daily_2021.march;

/**
 * @author： chenr
 * @date： Created on 2021/3/1 11:07
 * @version： v1.0
 * @modified By:
 */
public class NumArray_0301 {
    int [] nums;
    int sum;
    public NumArray_0301(int[] nums) {

        this.nums = nums;
    }

    public int sumRange(int i, int j) {
        for (int k = i; k <= j;k++) {
            sum += nums[k];
        }
        return sum;
    }
    class NumArray {
        int [] sums;

        public NumArray(int[] nums) {
            int n = nums.length;
            sums = new int[n+1];
            for (int i = 0; i < n; i++) {
                sums[i+1] = sums[i] + nums[i];
            }

        }

        public int sumRange(int i, int j) {

            return sums[j+1] - sums[i];
        }
    }
}
