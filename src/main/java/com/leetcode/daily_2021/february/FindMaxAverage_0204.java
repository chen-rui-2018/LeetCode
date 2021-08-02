package com.leetcode.daily_2021.february;

import java.util.Queue;

/**
 * @author： chenr
 * @date： Created on 2021/2/7 13:34
 * @version： v1.0
 * @modified By:
 */
public class FindMaxAverage_0204 {
    public static void main(String[] args) {
        int [] nums = {1,12,-5,-6,50,3};
        int k = 4;
        double result =   new FindMaxAverage_0204().findMaxAverage(nums,k);
        System.out.println(result);
    }
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        double maxAverage = sum / k;
        for (int i = k; i < n; i++) {
            sum += nums[i] - nums[i-k];
            maxAverage = Math.max(maxAverage,sum / k);
        }

        return maxAverage;
    }

}
