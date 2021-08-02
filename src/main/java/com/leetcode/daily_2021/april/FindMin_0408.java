package com.leetcode.daily_2021.april;

import com.sun.javafx.robot.FXRobotImage;

/**
 * @author： chenr
 * @date： Created on 2021/4/8 9:39
 * @version： v1.0
 * @modified By:
 */
public class FindMin_0408 {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
     int result =  new FindMin_0408().findMin(nums);
        System.out.println(result );
    }
    public int findMin1(int[] nums) {
        int length = nums.length;
        int min = nums[0];
        for (int i = 0; i < length; i++) {
            min = Math.min(min,nums[i]);
        }
        return min;
    }
    public int findMin(int[] nums) {
        int length = nums.length;
        int low = 0;
        int high = length-1;

        while ( low < high){
            int mid = low + (high-low) / 2;
            if (nums[mid] < nums[high]) {
                high = mid;
            }else {
                low = mid+1;
            }
        }
        return nums[low];
    }
}
