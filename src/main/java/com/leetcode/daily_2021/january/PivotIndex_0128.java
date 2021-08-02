package com.leetcode.daily_2021.january;

/**
 * @author： chenr
 * @date： Created on 2021/1/28 9:20
 * @version： v1.0
 * @modified By:
 */
public class PivotIndex_0128 {
    public static void main(String[] args) {
        int[] nums = {};
        int ans = new PivotIndex_0128().pivotIndex(nums);
        System.out.println(ans);
    }

    public int pivotIndex(int[] nums) {
        int prev = 0;
        int after = 0;
        for (int i = 0; i < nums.length; i++) {
            after += nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            if(i > 0 ) {
                prev += nums[i - 1];
            }
            after -= nums[i];
            if (prev == after) {
                return i;
            }
        }
        return -1;
    }
}
