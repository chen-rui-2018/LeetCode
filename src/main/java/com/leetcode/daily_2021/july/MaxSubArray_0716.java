package com.leetcode.daily_2021.july;

/**
 * @author： chenr
 * @date： Created on 2021/7/19 11:00
 * @version： v1.0
 * @modified By:
 */
public class MaxSubArray_0716 {
    public static void main(String[] args) {
//      int[] nums = {  -2,1,-3,4,-1,2,1,-5,4};
      int[] nums = {  -2,-1};
        int i = new MaxSubArray_0716().maxSubArray(nums);
        System.out.println(i);

    }
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0], temp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (temp < 0 && nums[i] > temp){
                temp = nums[i];
            }else {
                temp += nums[i];
            }
            maxSum = Math.max(maxSum, temp);


        }
         return maxSum;
    }
}
