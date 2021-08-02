package com.leetcode.daily_2021.june;


/**
 * @author： chenr
 * @date： Created on 2021/6/11 17:46
 * @version： v1.0
 * @modified By:
 */
public class NumSquares_0611 {
    public static void main(String[] args) {
        int sum = new NumSquares_0611().numSquares(4);
        System.out.println(sum);

    }
    public  int numSquares(int n){
        int[] dp = new int[n+1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; i - j * j >= 0 ; j++) {
                dp[i] = Math.min(dp[i],dp[i - j * j]+1);
            }
        }
        return dp[n];
    }
}
