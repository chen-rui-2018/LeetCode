package com.leetcode.daily_2021.april;

import com.leetcode.daily_2021.march.RemoveDuplicates;

/**
 * @author： chenr
 * @date： Created on 2021/4/6 10:15
 * @version： v1.0
 * @modified By:
 */
public class RemoveDuplicates_0406 {
    public static void main(String[] args) {
        int[] nums={1,1,1,2,2,3};
       int result =  new RemoveDuplicates_0406().removeDuplicates(nums);
        System.out.println(result);
    }
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        if (length <= 2) {
            return length;
        }
        int slow = 2;
        int fast = 2;
        while (fast < length) {
            if (nums[slow-2] != nums[fast]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
