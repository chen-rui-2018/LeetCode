package com.leetcode.daily_2021.july;

import java.util.Arrays;

/**
 * @author： chenr
 * @date： Created on 2021/7/15 9:53
 * @version： v1.0
 * @modified By:
 */
public class MaximumEleentAfterDecrementingAndRearranging_0715 {
    public static void main(String[] args) {
//        int[] arr = {2,2,1,2,1};
//        int[] arr = {1,2,3,4,5};
        int[] arr = {1, 2, 2, 4};
        int i = new MaximumEleentAfterDecrementingAndRearranging_0715().maximumElementAfterDecrementingAndRearranging(arr);
        System.out.println(i);
    }

    public int maximumElementAfterDecrementingAndRearranging1(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        if (n == 1) {
            return arr[0];
        }
        arr[0] = 1;
        int maxn = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] > n) {
                return n;
            }
            int temp = arr[i] - arr[i - 1];
            if (temp > 1) {
                arr[i] = arr[i - 1] + 1;
            }
            maxn = Math.max(arr[i], maxn);
        }
        return maxn;
    }

    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length;
        int[] cnt = new int[n + 1];
        for (int v : arr) {
            cnt[Math.min(v, n)]++;
        }
        int miss = 0;
        for (int i = 1; i <= n; i++) {
            if (cnt[i] == 0) {
                miss++;
            } else {
                miss -= Math.min(cnt[i] - 1, miss);
            }
        }
        return n - miss;
    }
}
