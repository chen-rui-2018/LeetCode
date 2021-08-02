package com.leetcode.daily_2021.february;

import java.util.Arrays;

/**
 * @author： chenr
 * @date： Created on 2021/2/18 14:25
 * @version： v1.0
 * @modified By:
 */
public class ArrayPairSum_0216 {
    public static void main(String[] args) {

    }
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i+=2) {
            sum += nums[i];
        }
        return sum;

    }
}
