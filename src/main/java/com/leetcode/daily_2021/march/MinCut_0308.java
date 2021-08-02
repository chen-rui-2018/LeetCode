package com.leetcode.daily_2021.march;

/**
 * @author： chenr
 * @date： Created on 2021/3/8 15:13
 * @version： v1.0
 * @modified By:
 */
public class MinCut_0308 {
    public static void main(String[] args) {
     int result =   new  MinCut_0308().minCut("aab");
        System.out.println(result);
    }
    public int minCut(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();
        boolean[][] st =  new  boolean[n][n];
        for (int j = 0; j < n; j++) {
            for (int i = j; i >= 0; i--) {
                if (i == j) {
                    st[i][j] = true;
                }else {
                    if (j - i + 1 == 2) {
                        st[i][j] = cs[i] == cs[j];
                    }else {
                        st[i][j] = cs [i] == cs[j] && st[i+1][j-1];
                    }
                }
            }
        }
        int [] f = new int[n];
        for (int j = 1; j < n; j++) {
            if (st[0][j]){
                f[j] = 0;
            }else {
                f[j] = f[j-1] + 1;
                for (int i = 1; i < j; i++) {
                    if(st[i][j]) {
                        f[j] = Math.min(f[j],f[i-1]+1);
                    }
                }
            }
        }
       return f[n-1];
    }
}
