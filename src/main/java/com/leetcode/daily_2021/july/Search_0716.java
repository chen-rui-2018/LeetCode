package com.leetcode.daily_2021.july;

/**
 * @author： chenr
 * @date： Created on 2021/7/16 16:51
 * @version： v1.0
 * @modified By:
 */
public class Search_0716 {
    public static void main(String[] args) {
        int [] nums = {1,1};
        int target = 1;
        int search = new Search_0716().search(nums, target);
        System.out.println(search);
    }
    public int search1(int[] nums, int target) {
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == target) {
                ret++;
            }
            if (nums[i] > target) {
                break;
            }
        }
        return ret;
    }
    public int search(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return rightIdx - leftIdx + 1;
        }
        return 0;
    }

    public int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

}
