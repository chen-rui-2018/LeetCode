package com.leetcode.editor.title_daily;

import java.util.Arrays;

/**
 * @author： chenr
 * @date： Created on 2020/12/1 8:50
 * @version： v1.0
 * @modified By:
 */
public class SearchRange {
    public static void main(String[] args) {
        int [] nums = {5,7,7,8,8,10};
        int target = 8 ;
        int [] res = new SearchRange().searchRange(nums,target);
        System.out.println(Arrays.toString(res));
    }
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        int start = 0;
        int end = nums.length-1;
        int mid = (start + end) / 2;
        boolean flag = false;
        while (start <= end){
            mid =  (start + end) / 2;
            if (nums[mid] == target) {
                flag = true;
                break;
            }else if(nums[mid] < target){
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        if(flag){
            int left = mid;
            int right = mid;
            while(left > 0 && nums[left-1] == target){
                left--;
            }
            while(right <= nums.length-2 && nums[right+1] == target){
                right++;
            }
            ans[0] = left;
            ans[1] = right;
        }else {
            ans[1] = -1;
            ans[0] = -1;
        }
        return ans;
    }
}
