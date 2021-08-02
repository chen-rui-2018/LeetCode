package com.leetcode.daily_2021.february;

/**
 * @author： chenr
 * @date： Created on 2021/2/7 11:04
 * @version： v1.0
 * @modified By:
 */
public class EqualSubstring_0205 {
    public static void main(String[] args) {

    }
    public int equalSubstring(String s, String t, int maxCost) {
        int length = s.length();
        int[] diff = new  int[length];
        for (int i = 0; i < length; i++) {
            diff[i] = Math.abs( s.charAt(i) - t.charAt(i) );
        }
        int sum = 0;
        int start = 0, end = 0;
        int maxLength = 0;
        while (end  < length){
            sum += diff[end];
            while (sum  >  maxCost) {
                sum -= diff[start];
                start++;
            }
            maxLength = Math.max(maxLength,end - start+1);
            end++;
        }
        return maxLength;
    }
}
