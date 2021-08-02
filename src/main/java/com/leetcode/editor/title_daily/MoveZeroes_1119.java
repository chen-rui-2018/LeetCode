package com.leetcode.editor.title_daily;

import java.util.Arrays;

/**
 * @author： chenr
 * @date： Created on 2020/11/19 17:12
 * @version： v1.0
 * @modified By:
 */
public class MoveZeroes_1119 {
    public static void main(String[] args) {
//        int [] nums = {0,0,1};
        int [] nums = {0,1,0,3,12};
//        new  MoveZeroes_1119().moveZeroes(nums);
        new  MoveZeroes_1119().moveZeroes2(nums);
        System.out.println(Arrays.toString(nums));
    }
    public void moveZeroes(int[] nums) {
        int length = nums.length;
        int index = length-1;
        int num = 0;
        while (index >=0){
            if (nums[index] == 0){
                for (int i = index; i < length-num-1; i++) {
                    int temp = nums[i+1];
                    nums[i+1]  = nums[i];
                    nums[i] = temp;
                }
                num++;
            }
            index--;

        }
    }
    public void moveZeroes2(int[] nums){
        if(nums == null){
            return;
        }
        int j = 0;
        for (int i = 0; i < nums.length ; i++) {
            if(nums[i] != 0){
                nums[j] = nums[i];
                j++;
            }
        }
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;

        }
    }
}
