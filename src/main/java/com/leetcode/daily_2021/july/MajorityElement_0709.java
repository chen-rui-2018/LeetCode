package com.leetcode.daily_2021.july;

/**
 * @author： chenr
 * @date： Created on 2021/7/9 9:38
 * @version： v1.0
 * @modified By:
 */
public class MajorityElement_0709 {
    public static void main(String[] args) {
        int [] nums = {3,3,4};
        int i = new MajorityElement_0709().majorityElement(nums);
        System.out.println(i);
    }
    public int majorityElement(int[] nums) {
        int count = 0;
        int temp = -1;
        for (int num : nums) {
            if (count == 0){
                temp = num;
                count++;
            }else if( num == temp){
                count++;
            }else {
                count--;
            }
        }
        count = 0;
        for (int num : nums) {
            if (temp == num) {
                count++;
            }
        }
        return count * 2 > nums.length ? temp : -1;
    }
}
