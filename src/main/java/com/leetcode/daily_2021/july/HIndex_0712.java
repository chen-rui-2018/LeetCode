package com.leetcode.daily_2021.july;

/**
 * @author： chenr
 * @date： Created on 2021/7/12 14:32
 * @version： v1.0
 * @modified By:
 */
public class HIndex_0712 {
    public static void main(String[] args) {
        int[] citations = {0, 1, 3, 5, 6};
        int i = new HIndex_0712().hIndex(citations);
        System.out.println(i);
    }

    public int hIndex1(int[] citations) {
        int h = 0, i = citations.length - 1;
        while (i >= 0 && h < citations[i]) {
            h++;
            i--;
        }
        return h;
    }

    public int hIndex(int[] citations) {
        int n = citations.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (citations[mid] >= n - mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return n - left;
    }

}
