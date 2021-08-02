package com.leetcode.daily_2021.june;

/**
 * @author： chenr
 * @date： Created on 2021/6/16 9:11
 * @version： v1.0
 * @modified By:
 */
public class StoneGame_0616 {
    public static void main(String[] args) {
        int [] piles = {1,5,233,7};
        boolean b = new StoneGame_0616().stoneGame(piles);
        System.out.println(b);

    }
    public boolean stoneGame(int[] piles) {
        int length = piles.length;
        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = piles[i];
        }
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
            }
        }
        return dp[0][length - 1] > 0;


    }
}
