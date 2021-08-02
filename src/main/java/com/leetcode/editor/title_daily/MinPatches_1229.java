package com.leetcode.editor.title_daily;

/**
 * @author： chenr
 * @date： Created on 2020/12/29 9:42
 * @version： v1.0
 * @modified By:
 */
public class MinPatches_1229 {
    public static void main(String[] args) {
        int[] nums = {1,5,10};
        int n = 20;
        System.out.println(new MinPatches_1229().minPatches(nums,n));

    }
    public int minPatches(int[] nums, int n) {
        int count = 0;
        int length = nums.length;
        int index = 0;
        long x = 1;
        while(x <= n){
            if(index < length && nums[index] <= x){
                x += nums[index++];
            }else{
                x *= 2;
                count++;
            }
        }
        return count;
    }

}
