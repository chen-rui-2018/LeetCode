package com.leetcode.daily_2021.february;

/**
 * @author： chenr
 * @date： Created on 2021/3/1 14:37
 * @version： v1.0
 * @modified By:
 */
public class IsMonotonic_0228 {
    public static void main(String[] args) {

    }
    public boolean isMonotonic(int[] A) {
        boolean isIncrease = true;
        boolean isDecrease = true;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i-1]) {
                isIncrease = false;
            }
            if (A[i] < A[i-1]){
                isDecrease = false;
            }
        }
        return isIncrease || isDecrease;
    }

}
