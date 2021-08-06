package com.leetcode.daily_2021.august;

import java.util.Arrays;

/**
 * @author： chenr
 * @date： Created on 2021/8/4 9:21
 * @version： v1.0
 * @modified By:
 */
public class D0804_triangleNumber {
    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 4};

        int i = new D0804_triangleNumber().triangleNumber(nums);
        System.out.println(i);
    }

    public int triangleNumber1(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int length = nums.length;
        int count = 0;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                int left = j + 1, right = length - 1, k = j;
                while (left <= right) {
                    int mid = (right - left) / 2 + left;
                    if (nums[mid] < nums[i] + nums[j]) {
                        k = mid;
                        left = mid + 1;

                    } else {
                        right = mid - 1;
                    }
                }
                count += k - j;
            }
        }
        return count;
    }

    public int triangleNumber(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int length = nums.length;
        int count = 0;
        for (int i = 0; i < length - 1; i++) {

            for (int j = i + 1; j < length; j++) {
                int k = j;
                while (k + 1 < length && nums[k + 1] < nums[i] + nums[j]) {
                   k++;
                }
                count += Math.max(k - j, 0);
            }
        }
        return count;
    }
}
