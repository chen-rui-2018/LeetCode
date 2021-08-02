package com.leetcode.editor.title_daily;

import java.util.Arrays;

/**
 * @author： chenr
 * @date： Created on 2020/12/2 8:42
 * @version： v1.0
 * @modified By:
 */
public class MaxNumber_1202 {
    public static void main(String[] args) {
       int[] nums1 = {3, 4, 6, 5};
       int[] nums2 = {9, 1, 2, 5, 8, 3};
       int k = 5;
       int[]  result =  new MaxNumber_1202().maxNumber(nums1,nums2,k);
        System.out.println(Arrays.toString(result));
    }
    public int[] maxNumber(int[] nums1, int[] nums2, int k){
        int[] res = new int[k];
        for (int i = 0; i <= k && i <= nums1.length; i++) {
            if(k-i >= 0 && k-i <= nums2.length){
                int [] temp = merge (subMaxNumber(nums1,i),subMaxNumber(nums2,k-i));
                if(compare(temp,0,res,0)){
                    res = temp;
                }
            }
        }
        return  res;
    }
    public int[] merge (int[] nums1,int[] nums2){
        int[] res = new int[nums1.length + nums2.length];
        int cur = 0;
        int p1 = 0,p2 = 0;
        while(cur < nums1.length + nums2.length){
            if(compare(nums1,p1,nums2,p2) ){
                res[cur++] = nums1[p1++];
            }else{
                res[cur++] = nums2[p2++];
            }
        }
        return res;
    }
    public int[] subMaxNumber(int[] nums, int len){
        int[] subNums = new int[len];
        int cur = 0;
        int rem  = nums.length-len;
        for (int i = 0; i < nums.length; i++) {
            while(cur > 0 && subNums[cur-1] < nums[i] && rem > 0){
                cur--;
                rem--;
            }
            if(cur < len){
                subNums[cur++] = nums[i];

            }else {
                rem--;
            }
        }
        return subNums;
    }
    public boolean compare(int[] nums1,int p1,int[] nums2, int p2){
        if(p2 >= nums2.length ){
            return true;
        }
        if(p1 >= nums1.length){
            return false;
        }
        if(nums1[p1] > nums2[p2]){
            return true;

        }
        if(nums1[p1] < nums2[p2]){
            return false;
        }
        return compare(nums1,p1+1,nums2,p2+1);

    }

}
