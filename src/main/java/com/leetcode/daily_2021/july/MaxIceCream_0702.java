package com.leetcode.daily_2021.july;

import java.util.Arrays;

/**
 * @author： chenr
 * @date： Created on 2021/7/2 9:29
 * @version： v1.0
 * @modified By:
 */
public class MaxIceCream_0702 {
    public static void main(String[] args) {
        int[] costs ={1,6,3,1,2,5};
//        int[] costs ={10,6,8,7,7,8};
//        int[] costs ={1,6,3,1,2,5};
        int coins = 7;
        int i = new MaxIceCream_0702().maxIceCream(costs, coins);
        System.out.println(i);
    }

    /**
     * ArraysSort
     * @param costs
     * @param coins
     * @return
     */
    public int maxIceCream1(int[] costs, int coins) {
        int count = 0;
        if(costs == null || costs.length <= 0) {
            return count;
        }
        Arrays.sort(costs);
        for (int i = 0; i < costs.length; i++) {
            coins -= costs[i];
            if (coins < 0) {
                count = i;
                break;
            }else {
                count = costs.length;
            }

        }
        return count;
    }

    /**
     * 计数排序
     * @param costs
     * @param coins
     * @return
     */
    public int maxIceCream(int[] costs, int coins) {
        int[] freArr = new int[100001];
        for (int cost : costs) {
            freArr[cost]++;
        }
        int count = 0;
        for (int i = 1; i < freArr.length; i++) {
            if (coins >= i) {
                int curCount = Math.min(freArr[i],coins / i);
                count += curCount;
                coins -=  curCount * i;
            }else {
                break;
            }
        }
        return count;

    }
}
