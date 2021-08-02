package com.leetcode.daily_2021.february;

/**
 * @author： chenr
 * @date： Created on 2021/2/18 14:32
 * @version： v1.0
 * @modified By:
 */
public class FindMaxConsecutiveOnes_0215 {
    public static void main(String[] args) {

    }
    public int findMaxConsecutiveOnes(int[] nums) {
        int sum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0){
                sum = Math.max(sum,count);
                count = 0;
            }else {
                count++;
            }

        }
        sum = Math.max(sum,count);
        return sum;
    }
}
