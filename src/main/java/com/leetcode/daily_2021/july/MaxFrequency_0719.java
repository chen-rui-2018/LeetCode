package com.leetcode.daily_2021.july;

import java.util.Arrays;

/**
 * @author： chenr
 * @date： Created on 2021/7/19 9:44
 * @version： v1.0
 * @modified By:
 */
public class MaxFrequency_0719 {
    public static void main(String[] args) {
        int [] nums = {1,4,8,13};
        int k = 5;
        int i = new MaxFrequency_0719().maxFrequency(nums, k);
        System.out.println(i);
    }

    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int l = 0,  res = 1;
        long total = 0;
        for (int r = 1; r < n; r++) {
            total += (long) (nums[r] - nums[r-1]) * (r -l);
            while (k < total ){
              total -= nums[r] - nums[l];
              l++;
            }
            res = Math.max(res,r-l+1);

        }
        return res;
    }
}
