package com.leetcode.daily_2021.february;

/**
 * @author： chenr
 * @date： Created on 2021/2/19 15:22
 * @version： v1.0
 * @modified By:
 */
public class SubarraysWithKDistinct_0209 {
    public static void main(String[] args) {

    }
    public int subarraysWithKDistinct(int[] A, int K) {
        return atMostKDistinct(A, K) - atMostKDistinct(A, K - 1);
    }

    private int atMostKDistinct(int[] a, int k) {
        int len = a.length;
        int[] freq = new int[len + 1];
        int left = 0;
        int right = 0;
        int count = 0;
        int res = 0;
        while (right < len) {
            if (freq[a[right]] == 0) {
                count++;
            }
            freq[a[right]]++;
            right++;
            while (count > k) {
                freq[a[left]]--;
                if (freq[a[left]] == 0 ) {
                    count--;
                }
                left++;
            }
            res += right - left;
        }
        return res;
    }
}
