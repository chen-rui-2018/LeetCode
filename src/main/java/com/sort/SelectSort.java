package com.sort;

import java.util.Arrays;

/**
 * 选择排序
 * @author： chenr
 * @date： Created on 2021/7/20 10:19
 * @version： v1.0
 * @modified By:
 */
public class SelectSort {

    public static void main(String[] args) {
        int [] arr = {9,8,7,6,5,4,3,2,1};
        int[] selectSort =  new SelectSort().doSelectSort(arr);


        System.out.println(Arrays.toString(selectSort));
        System.out.println("yyyy-mm-dd HH:mm:ss".substring(0,16));
    }

    public int[] doSelectSort(int[] nums){
        if (nums == null || nums.length <= 1){
            return nums;
        }
        for (int i = 0; i < nums.length-1; i++) {
            int index = i;
            for (int j = i+1; j < nums.length; j++) {
                if (nums[index] > nums [j]) {
                    index = j;
                }
            }
            if (index == i ) {
                continue;
            }
            int temp = nums[i];
            nums[i] = nums[index];
            nums[index] = temp;
        }
        return nums;
    }
}
