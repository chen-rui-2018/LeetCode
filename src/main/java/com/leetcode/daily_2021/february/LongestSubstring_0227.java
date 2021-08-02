package com.leetcode.daily_2021.february;

import java.util.Arrays;

/**
 * @author： chenr
 * @date： Created on 2021/3/1 11:27
 * @version： v1.0
 * @modified By:
 */
public class LongestSubstring_0227 {
    public static void main(String[] args) {
            String s = "aaaab";
            int k = 2;
        System.out.println(new LongestSubstring_0227().longestSubstring(s,k));
    }
    public int longestSubstring(String s, int k) {
        int ans = 0;
        int n = s.length();
        char[] cs = s.toCharArray();
        int[] cnt = new int[26];
        for (int p = 1; p <= cnt.length ; p++) {
            Arrays.fill(cnt,0);
            for (int i = 0,j = 0,tot = 0,sum = 0; i < n; i++) {
                int u = cs[i] -'a';
                cnt[u]++;
                if (cnt[u] == 1 ){
                    tot++;
                }
                if (cnt[u] == k){
                    sum++;
                }
                while (tot > p) {
                    int t = cs[j++] - 'a';
                    cnt[t]--;
                    if (cnt[t] == 0){
                        tot--;
                    }
                    if (cnt[t] == k-1){
                        sum--;
                    }
                }
                if (tot == sum) {
                    ans =Math.max(ans,i-j+1);
                }
            }
        }
        return ans;
    }
}
