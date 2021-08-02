package com.leetcode.daily_2021.april;

/**
 * @author： chenr
 * @date： Created on 2021/4/7 9:19
 * @version： v1.0
 * @modified By:
 */
public class Search_0407 {
    public static void main(String[] args) {
        int[] nums = {2,5,6,0,0,1,2};
        int target = 0;
        boolean result = new Search_0407().search(nums, target);
        System.out.println(result);
    }

    public boolean search1(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == target) {
                return true;
            }
        }
        return false;
//        int right = n-1;
//        int left = 0;
//        while  (left <= right) {
//            if (nums[left] == target) {
//                return true;
//            }else if ( target > nums[left]) {
//                if(left+1 >=n || nums[left+1] < nums[left] || target < nums[left+1]) {
//                    return false;
//                }
//                left++;
//            }else  if (target == nums[right]){
//                return true;
//            }else if (target < nums[right]) {
//                if (right-1 < 0 || nums[right-1] > nums[right] || target >nums[right-1] ) {
//                    return false;
//                }
//                right--;
//            }
//        }
//        return false;
    }

    public boolean search(int[] nums, int target) {
        int n = nums.length;
        if ( n == 0) {
            return false;
        }
        if (n == 1) {
            return nums[0] == target;
        }
        int right = n - 1;
        int left = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if ( nums[mid] == target) {
                return true;
            }

            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
               left++;
               right--;
            }else if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]){
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }else {
                if (nums[mid] < target  && target <= nums[n-1]){
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}
