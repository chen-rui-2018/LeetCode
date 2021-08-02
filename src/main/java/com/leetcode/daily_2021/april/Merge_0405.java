package com.leetcode.daily_2021.april;

import com.sun.corba.se.impl.orbutil.CorbaResourceUtil;

import java.util.Arrays;

/**
 * @author： chenr
 * @date： Created on 2021/4/5 11:48
 * @version： v1.0
 * @modified By:
 */
public class Merge_0405 {
    public static void main(String[] args) {
       int[] nums1 = {1};
       int m = 1, n = 0;
       int[]  nums2 = {};
        new Merge_0405().merge(nums1,m,nums2,n);
        System.out.println(" sdfsf");


    }

    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = Arrays.copyOfRange(nums1,0,m);
        int index1 = 0;
        int index2 = 0;
        int index = 0;
        while (index1 < m && index2 < n) {
            if  (temp[index1] <= nums2[index2]) {
                nums1[index] = temp[index1];
                index1++;
            } else {
                nums1[index] = nums2[index2];
                index2++;
            }
            index++;
        }
        while (index1 < m) {
            nums1[index] = temp[index1];
            index1++;
            index++;
        }
        while (index2 < n) {
            nums1[index] = nums2[index2];
            index2++;
            index++;
        }

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m-1;
        int p2 = n-1;
        int p =  n+m-1;
        while (p1>=0 && p2>=0) {
            nums1[p--] = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];
        }
        System.arraycopy(nums2,0,nums1,0,p2+1);
        System.out.println("2313");
    }
}
