package com.leetcode.daily_2021.february;

import java.util.Arrays;

/**
 * @author： chenr
 * @date： Created on 2021/2/18 16:52
 * @version： v1.0
 * @modified By:
 */
public class CheckInclusion_0210 {
    public static void main(String[] args) {

    }
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if (m < n){
            return false;
        }
        int[] arrs1 = new int[26];
        int[] arrs2 = new int[26];
        for (int i = 0; i < n; i++) {
            arrs1[s1.charAt(i) - 'a']++;
            arrs2[s2.charAt(i) - 'a']++;
        }
        if (Arrays.equals(arrs1,arrs2)) {
            return true;
        }
        for (int i = n; i < m; i++) {
            arrs2[s2.charAt(i) - 'a']++;
            arrs2[s2.charAt(i-n) - 'a']--;
            if (Arrays.equals(arrs1,arrs2)) {
                return true;
            }
        }
        return false;
    }
}
