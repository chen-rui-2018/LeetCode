package com.sort;

import java.util.Arrays;

/**
 * @author： chenr
 * @date： Created on 2021/7/20 11:03
 * @version： v1.0
 * @modified By:
 */
public class InsertionSort {
    public static void main(String[] args) {
        int [] arr = {9,8,7,6,5,4,3,2,1};
        int[] insertionSort =new InsertionSort().doInsertionSort(arr);
        System.out.println(Arrays.toString(insertionSort));
    }
    public  int[] doInsertionSort(int[] nums){
        if (nums == null || nums.length <= 1){
            return nums;
        }
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j > 0 ; j--) {
                if (nums[j] < nums[j-1]) {
                    int temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                }
            }
        }

        return nums;
    }
}
