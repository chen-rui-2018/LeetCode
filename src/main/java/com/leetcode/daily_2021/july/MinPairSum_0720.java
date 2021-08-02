package com.leetcode.daily_2021.july;

import java.util.Arrays;

/**
 * @author： chenr
 * @date： Created on 2021/7/20 9:13
 * @version： v1.0
 * @modified By:
 */
public class MinPairSum_0720 {
    public static void main(String[] args) {
        int[] nums = {3,5,4,2,4,6};
        int i = new MinPairSum_0720().minPairSum(nums);
        System.out.println(i);
    }

    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int maxn = 0;
        int l = 0, r = nums.length-1;
        while (l < r){
           maxn = Math.max(maxn,nums[l] + nums[r]);
           l++;
           r--;
        }
        return maxn;

    }
}
