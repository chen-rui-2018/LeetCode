package com.leetcode.daily_2021.june;

/**
 * @author： chenr
 * @date： Created on 2021/6/2 9:16
 * @version： v1.0
 * @modified By:
 * [favoriteTypei, favoriteDayi, dailyCapi]
 */
public class CanEat_0601 {
    public static void main(String[] args) {
       int[] candiesCount = {7,4,5,3,8};
       int[][] queries = {{0,2,2},{4,2,4},{2,13,1000000000}};
       boolean [] result = new CanEat_0601().canEat(candiesCount,queries);
        for (boolean b : result) {
            System.out.println(b);
        }
    }
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        boolean [] result = new boolean[queries.length];
        long [] sum  = new long[candiesCount.length];
        sum[0] = candiesCount[0];
        for (int i = 1; i < candiesCount.length; i++) {
            sum[i] = sum[i-1] + candiesCount[i];
        }
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int favoriteType = query[0], favoriteDay = query[1], dailyCap = query[2];
            long x1 = favoriteDay + 1;
            long y1 = (long) (favoriteDay + 1) * dailyCap;
            long x2 = favoriteType == 0 ? 1 : sum[favoriteType - 1] + 1;
            long y2 = sum[favoriteType];

            result[i] = !(x1 > y2 || y1 < x2);

        }
        return result;
    }
}
