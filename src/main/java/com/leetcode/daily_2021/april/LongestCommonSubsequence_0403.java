package com.leetcode.daily_2021.april;

/**
 * @author： chenr
 * @date： Created on 2021/4/4 11:04
 * @version： v1.0
 * @modified By:
 */
public class LongestCommonSubsequence_0403 {
    public static void main(String[] args) {
     int result =   new LongestCommonSubsequence_0403().longestCommonSubsequence("abcde","ace");
        System.out.println(result);
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n ; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }

            }

        }
        return  dp[m][n];
    }
}
