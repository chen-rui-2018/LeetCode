package com.leetcode.editor.title_daily;

import java.util.Arrays;

/**
 * @author： chenr
 * @date： Created on 2020/11/26 10:58
 * @version： v1.0
 * @modified By:
 */
public class MaximumGap_1126 {
    public static void main(String[] args) {
        int [] nums = {1,3,4,5,6,10,11,12,17};
//      int result  =  new MaximumGap_1126().maximumGap(nums);
//        System.out.println(result);
        int result2  =  new MaximumGap_1126().maximumGap2(nums);
        System.out.println(result2);
    }
    public int maximumGap(int[] nums) {
        if(nums == null || nums.length <= 1){
            return 0;
        }
        int ans = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
            ans = Math.max(ans,nums[i+1] - nums[i]);
        }
        return ans;
    }
    public int maximumGap2(int[] nums) {
        int n = nums.length;
        int minLength = 2;
        if(n < minLength){
            return 0;
        }
        int minVal = Arrays.stream(nums).min().getAsInt();
        int maxVal = Arrays.stream(nums).max().getAsInt();
        int d = Math.max(1,(maxVal - minVal)/(n-1));
        int bucketSize = (maxVal-minVal) / d + 1;
        int [][] bucket = new int[bucketSize][2];
        for (int i = 0; i < bucketSize; i++) {
            Arrays.fill(bucket[i],-1);
        }
        for (int i = 0; i < n; i++) {
            int idx = (nums[i] - minVal) / d;
            if(bucket[idx][0] == -1){
                bucket[idx][0] = bucket[idx][1] = nums[i];
            }else{
                bucket[idx][0] = Math.min(bucket[idx][0],nums[i]);
                bucket[idx][1] = Math.max(bucket[idx][1],nums[i]);
            }

        }
        int ret = 0;
        int prev = -1;
        for (int i = 0; i < bucketSize; i++) {
            if(bucket[i][0] == -1){
                continue;
            }
            if(prev != -1){
                ret = Math.max(ret,bucket[i][0]-bucket[prev][1]);
            }
            prev = i;
        }
        return ret;
    }
}
