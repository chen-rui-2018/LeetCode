package com.leetcode.daily_2021.july;

import java.util.Arrays;

/**
 * @author： chenr
 * @date： Created on 2021/7/6 11:20
 * @version： v1.0
 * @modified By:
 */
public class FindErrorNums_0704 {
    public static void main(String[] args) {
        int [] nums = {1,1};
        int[] errorNums = new FindErrorNums_0704().findErrorNums(nums);
        System.out.println(Arrays.toString(errorNums));
    }
    public int[] findErrorNums(int[] nums) {
      int n = nums.length;
      int[] temp = new int[n+1];
        for (int num : nums) {
            temp[num]++;
        }
        int lose = 0,more = 0;
            for (int i = 1; i < temp.length; i++) {
            if (temp[i] == 0){
               lose = i;
            }else   if (temp[i] == 2){
                more = i;
            }
        }

        return new int[]{more,lose};
    }
}
