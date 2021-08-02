package com.leetcode.daily_2021.april;

import javax.sound.midi.Soundbank;

/**
 * @author： chenr
 * @date： Created on 2021/4/9 9:33
 * @version： v1.0
 * @modified By:
 */
public class FindMin_0409  {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,4};
      int result =    new FindMin_0409().findMin(nums);
        System.out.println(result);
    }

    public int findMin(int[] nums) {
        int length = nums.length;
        int slow = 0;
        int high = length-1;
        while (slow < high) {
            int mid = slow + ( high - slow ) / 2;
            if (nums[mid] > nums[high]) {
                slow = mid + 1;
            }else if (nums[mid] < nums[high]) {
                high = mid;
            }else {
                high--;
            }
        }
        return nums[slow];
    }
}
