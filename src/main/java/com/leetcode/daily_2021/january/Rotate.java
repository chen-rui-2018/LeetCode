package com.leetcode.daily_2021.january;

import java.util.Arrays;

/**
 * @author： chenr
 * @date： Created on 2021/1/8 11:09
 * @version： v1.0
 * @modified By:
 */
public class Rotate {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        new Rotate().rotate(arr,3);
        System.out.println(arr.length);
    }
    public void rotate1(int[] nums, int k) {
        int length = nums.length;
        int [] newNums = new int[length];
        for (int i = 0; i < length; i++) {
            newNums[(i+k)%length] = nums[i];
        }
        System.arraycopy(newNums,0,nums,0,length);
        System.out.println(Arrays.toString(nums));

    }
    public void rotate2(int[] nums, int k) {
        int length = nums.length;
        k = k%length;
        reverse(nums,0,length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,length-1);
        System.out.println(Arrays.toString(nums));

    }

    private void reverse(int[] nums, int start, int end) {
        while(start < end){
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
    public void rotate(int[] nums, int k) {
        int n= nums.length;
        k = k%n;
        int count = gcd(k,n);
        for (int i = 0; i < count; i++) {
            int current = i;
            int prev = nums[i];
            do{
                int next = (current + k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
            }while (i != current);
        }
    }

    private int gcd(int k, int n) {
        return n > 0?gcd(n,k%n) : k;
    }

}
