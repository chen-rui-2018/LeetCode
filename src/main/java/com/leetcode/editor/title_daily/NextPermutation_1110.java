package com.leetcode.editor.title_daily;

import java.util.Arrays;

/**
 * @author： chenr
 * @date： Created on 2020/11/10 9:53
 * @version： v1.0
 * @modified By:
 */
public class NextPermutation_1110 {
    public static void main(String[] args) {
        int[] nums = {3,2,1};
        new NextPermutation_1110().nextPermutation(nums);
    }

    public void nextPermutation(int[] nums) {
        int i = nums.length - 1;
        int j = nums.length - 1;
        int length = nums.length - 1;
        while (i > 0) {
            if (nums[i] > nums[i - 1]) {
                i--;
                break;
            }
            i--;
        }
        if (i == 0 && length > 1  && nums[0]>nums[1]) {
            while (i <= length) {
                int temp = nums[i];
                nums[i] = nums[length];
                nums[length] = temp;
                i++;
                length--;
            }
            System.out.println(Arrays.toString(nums));
            return;
        }else {
            while (j > 0) {
                if (nums[j] > nums[i]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    break;
                }
                j--;
            }
            i++;
            while (i <= length) {
                int temp = nums[i];
                nums[i] = nums[length];
                nums[length] = temp;
                i++;
                length--;
            }
            System.out.println(Arrays.toString(nums));
        }
    }
    public void nextPermutation2(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i+1]){
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums,i,j);
        }
        reverse(nums,i+1);
    }

    private void reverse(int[] nums, int i) {
        int left = i;
        int right = nums.length-1;
        while (left < right){
            swap(nums,left,right);
            left++;
            right--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
