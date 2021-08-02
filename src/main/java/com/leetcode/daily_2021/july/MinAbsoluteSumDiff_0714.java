package com.leetcode.daily_2021.july;

import java.util.Arrays;

/**
 * @author： chenr
 * @date： Created on 2021/7/14 9:35
 * @version： v1.0
 * @modified By:
 */
public class MinAbsoluteSumDiff_0714 {
    public static void main(String[] args) {

        int[] nums1 = {1};
        int[] nums2 = {2};
        int i = new MinAbsoluteSumDiff_0714().minAbsoluteSumDiff(nums1, nums2);
        System.out.println(i);
    }

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int MDD = 1000000007;
        int n = nums1.length;
        int[] rec = new int[n];
        System.arraycopy(nums1, 0, rec, 0, n);
        Arrays.sort(rec);
        int sum = 0, maxn = 0;
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            sum = (sum + diff) % MDD;
            int j = binarySearch(rec, nums2[i]);
            if (j < n) {
                maxn = Math.max(diff - (rec[j] - nums2[i]), maxn);
            }
            if (j > 0) {
                maxn = Math.max(diff - (nums2[i] - rec[j - 1]), maxn);
            }
        }
        return (sum - maxn + MDD) % MDD;
    }

    public int binarySearch(int[] rec, int target) {
        int low = 0, high = rec.length - 1;
        if (rec[high] < target) {
            return high + 1;
        }
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (rec[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
