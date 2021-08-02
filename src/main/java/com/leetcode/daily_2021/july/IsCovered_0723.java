package com.leetcode.daily_2021.july;

/**
 * @author： chenr
 * @date： Created on 2021/7/26 9:09
 * @version： v1.0
 * @modified By:
 */
public class IsCovered_0723 {
    public static void main(String[] args) {
        int[][] ranges = {{1,2},{3,4},{5,6}};
        boolean covered = new IsCovered_0723().isCovered(ranges, 2, 5);
        System.out.println(covered);
    }
    public boolean isCovered(int[][] ranges, int left, int right) {
         int[] diff = new int[52];
         int n = ranges.length;
        for (int i = 0; i < n; i++) {
            int start = ranges[i][0];
            int end = ranges[i][1];
            for (int j = start; j <= end; j++) {
                diff[j]++;
            }
        }
        for (int i = left; i <= right; i++) {
            if (diff[i] <= 0) {
                return false;
            }
        }
        return true;

    }
}
