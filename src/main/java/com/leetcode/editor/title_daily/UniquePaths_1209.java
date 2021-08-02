package com.leetcode.editor.title_daily;

import java.util.Arrays;

/**
 * @author： chenr
 * @date： Created on 2020/12/9 9:43
 * @version： v1.0
 * @modified By:
 */
public class UniquePaths_1209 {
    public static void main(String[] args) {
      int result =   new UniquePaths_1209().uniquePaths(3,2);
        System.out.println(result);
    }
    public int uniquePaths(int m, int n) {
        int[][] net = new int[m][n];
        Arrays.fill(net[0],1);
        for (int i = 0; i < m; i++) {
            net[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                net[i][j] = net[i][j-1] + net[i-1][j];
            }
        }
        return net[m-1][n-1];
    }
}
