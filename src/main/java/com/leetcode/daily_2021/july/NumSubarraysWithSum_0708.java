package com.leetcode.daily_2021.july;

import java.util.HashMap;
import java.util.Map;

/**
 * @author： chenr
 * @date： Created on 2021/7/9 10:39
 * @version： v1.0
 * @modified By:
 */
public class NumSubarraysWithSum_0708 {
    public static void main(String[] args) {
        int[] nums = {1,0,1,0,1};
        int goal = 2;

        int i = new NumSubarraysWithSum_0708().numSubarraysWithSum(nums, goal);
        System.out.println(i);
    }
    public int numSubarraysWithSum1(int[] nums, int goal) {
        int sum = 0;
        Map<Integer,Integer> cnt = new HashMap<>();
        int ret = 0;
        for (int num : nums) {
            cnt.put(sum,cnt.getOrDefault(sum,0)+1);
            sum += num;
            ret += cnt.getOrDefault(sum-goal,0);
        }
        return ret;
    }
    public int numSubarraysWithSum(int[] nums, int goal){

        int n = nums.length;
        int left1 = 0,left2 = 0, right = 0;
        int sum1 = 0,sum2 = 0;
        int ret = 0;
        while (right < n){
            sum1 += nums[right];
            while (left1 <= right && sum1 > goal) {
                sum1 -= nums[left1];
                left1++;
            }
            sum2+=nums[right];
            while (left2 <=right && sum2 >= goal) {
                sum2 -= nums[left2];
                left2++;
            }
            ret += left2 - left1;
            right++;
        }

        return ret;
    }
}
