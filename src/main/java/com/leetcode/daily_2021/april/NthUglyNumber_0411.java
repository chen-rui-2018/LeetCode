package com.leetcode.daily_2021.april;

/**
 * @author： chenr
 * @date： Created on 2021/4/11 22:12
 * @version： v1.0
 * @modified By:
 */
public class NthUglyNumber_0411 {
    public static void main(String[] args) {
      int result =  new NthUglyNumber_0411().nthUglyNumber(10);
        System.out.println(result);
    }
    // 逐个判断 超时
    public int nthUglyNumber1(int n) {
        int ans = 1;
        if (n == 1) {
            return ans;
        }
        int index = 2;
        while (index <= n) {
            ans++;
            if ( isUgluNumber(ans) ) {
                index++;
            }
        }
        return ans;
    }
    public boolean isUgluNumber(int number) {
        int[] params = {2,3,5};
        for (int param : params) {
            while ((number % param) == 0) {
                number /= param;
            }
        }
        return  number == 1;
    }
    public int nthUglyNumber(int n) {
        if (n <= 0) {
            return 0;
        }
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(dp[index2] * 2, Math.min(dp[index3] * 3, dp[index5] * 5 ));
            if (dp[i] == dp[index2] * 2 ) { index2++; }
            if (dp[i] == dp[index3] * 3 ) { index3++; }
            if (dp[i] == dp[index5] * 5 ) { index5++; }
        }
        return dp[n-1];
    }

}
