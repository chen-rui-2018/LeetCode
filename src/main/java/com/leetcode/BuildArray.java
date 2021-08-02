package com.leetcode;

import java.util.Arrays;

/**
 * @author： chenr
 * @date： Created on 2021/7/4 11:02
 * @version： v1.0
 * @modified By:
 */
public class BuildArray {
    public static void main(String[] args) {
        int[] nums = {};
        int[] ints = new BuildArray().buildArray(nums);
        System.out.println(Arrays.toString(ints));
    }
    public int[] buildArray(int[] nums) {
        int[] result  = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[ nums[i]];
        }
        return result;
    }
}
