package com.leetcode.editor.title_daily;

import com.sun.deploy.util.ArrayUtil;

import java.util.Arrays;

/**
 * @author： chenr
 * @date： Created on 2020/12/28 17:13
 * @version： v1.0
 * @modified By:
 */
public class MaxProfit_1228 {
    public static void main(String[] args) {
        int k = 6;
        int [] prices = {1,4,1,4,1,4};
        int result = new MaxProfit_1228().maxProfit(k,prices);
        System.out.println(result);
    }
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0){
            return 0;
        }
        int n = prices.length;
        k = Math.min(k,n/2);
        int[][] buy = new int[n][k+1];
        int[][] sell = new int[n][k+1];
        buy[0][0] = -prices[0];
        sell[0][0] = 0;
        for (int i = 1; i <= k; i++) {
            buy[0][i] = sell[0][i] = Integer.MIN_VALUE/2;
        }
        for (int i = 1; i < n; i++) {
            buy[i][0] = Math.max(buy[i-1][0],sell[i-1][0] - prices[i]);

            for (int j = 1; j <= k; j++) {

                buy[i][j] = Math.max(buy[i-1][j],sell[i-1][j]-prices[i]);

                sell[i][j] = Math.max(sell[i-1][j],buy[i-1][j-1]+prices[i]);
            }
        }
        return Arrays.stream(sell[n-1]).max().getAsInt();
    }
}
