package com.leetcode.daily_2021.february;

/**
 * @author： chenr
 * @date： Created on 2021/2/19 9:45
 * @version： v1.0
 * @modified By:
 */
public class LongestOnes_0219 {
    public static void main(String[] args) {
        int[] A = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k = 3;
        int result = new LongestOnes_0219().longestOnes(A, k);
        System.out.println(result);
    }

    public int longestOnes1(int[] A, int K) {
        int length = A.length;
        int i = 0, j = 0;
        int zeroCount = 0;
        int maxCount = 0;
        while (i < length) {
            if (A[i] == 0 && zeroCount <= K) {
                zeroCount++;
                i++;
            }else if (A[i] == 1) {
                i++;
            }
            while (zeroCount > K && j < i) {
                    maxCount = Math.max(maxCount, i - j-1);
                    if (A[j] == 0) {
                        zeroCount--;
                    }
                    j++;
                }

        }
        maxCount = Math.max(maxCount, i - j);
        return maxCount;

    } public int longestOnes(int[] A, int K) {
        int length = A.length;
        int right = 0, left = 0;
        int zeroCount = 0;
        int maxCount = 0;
        while ( right < length){
            if (A[right] == 0){
                zeroCount++;
            }
            while (zeroCount > K) {
                if (A[left] == 0){
                    zeroCount--;
                }
                left++;
            }
            right++;
            maxCount = Math.max(maxCount,right - left);
        }
        return maxCount;

    }
}
