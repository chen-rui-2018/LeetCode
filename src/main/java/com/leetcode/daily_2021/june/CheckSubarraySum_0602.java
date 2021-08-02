package com.leetcode.daily_2021.june;

import java.util.HashMap;
import java.util.Map;

/**
 * @author： chenr
 * @date： Created on 2021/6/2 10:54
 * @version： v1.0
 * @modified By:
 * [23,2,4,6,6]
 * 7
 */
public class CheckSubarraySum_0602 {
    public static void main(String[] args) {
        int[] nums = {5,0,0,0};
        int k = 3;
        System.out.println(     new CheckSubarraySum_0602().checkSubarraySum(nums,k));
    }
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length < 2){
            return false;
        }
        long[] sum = new long[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i-1] + nums[i];
        }
        Map<Long,Integer> map = new HashMap<>(16);
        map.put(0L,-1);
        for (int i = 0; i < sum.length ; i++) {
            long temp = sum[i] % k;
            if (map.containsKey(temp)) {
                int preIndex = map.get(temp);
                if (i - preIndex >= 2){
                    return true;
                }
            }else {
                map.put(temp, i);
            }
        }
        return false;
    }
}
