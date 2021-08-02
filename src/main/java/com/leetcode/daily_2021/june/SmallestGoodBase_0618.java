package com.leetcode.daily_2021.june;

/**
 * @author： chenr
 * @date： Created on 2021/6/18 9:15
 * @version： v1.0
 * @modified By:
 */
public class SmallestGoodBase_0618 {
    public static void main(String[] args) {
        String s = new SmallestGoodBase_0618().smallestGoodBase("13");
        System.out.println(s);
    }
    public String smallestGoodBase1(String n) {
        long N= Long.parseLong(n);
        for (int m = 59; m > 1 ; m--) {
            long k = (long) Math.pow(N,1.0/m);
            if (k <= 1) {
                continue;
            }
            long s = 0;
            for (int i = 0; i <= m; i++) {
                s = s*k+1;
                if (s == N) {
                    return String.valueOf(k);
                }
            }
        }
        return String.valueOf(N-1);
    }
    public String smallestGoodBase(String n) {
        long nVal = Long.parseLong(n);
        int mMax = (int) Math.floor(Math.log(nVal)/Math.log(2));
        for (int m = mMax; m >1 ; m--) {
            int k = (int)Math.pow(nVal,1.0/m);
            long mul = 1,sum =1;
            for (int i = 0; i < m; i++) {
                mul *= k;
                sum += mul;
            }
            if (sum == nVal) {
                return Integer.toString(k);
            }
        }
        return String.valueOf(nVal-1);
    }
}
