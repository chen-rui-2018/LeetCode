package com.leetcode.daily_2021.january;

/**
 * @author： chenr
 * @date： Created on 2021/1/9 9:20
 * @version： v1.0
 * @modified By:
 */
public class MaxProfit {
    public static void main(String[] args) {
        int [] prices = {3,3,5,0,0,3,1,4};
       int result = new MaxProfit().maxProfit(prices);
        System.out.println(result);
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy1 = -prices[0];
        int sell1 = 0;
        int buy2 = -prices[0];
        int sell2 = 0;
        for (int i = 1; i < n; i++) {
            buy1 = Math.max(buy1,-prices[i]);
            sell1 = Math.max(sell1,prices[i] + buy1);
            buy2 = Math.max(buy2,sell1-prices[i]);
            sell2 = Math.max(sell2,buy2+prices[i]);
        }
        return sell2;
    }
}
