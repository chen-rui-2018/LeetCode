package com.leetcode.editor.title_daily;
import java.util.HashMap;
import java.util.Map;

/**
 * @author： chenr
 * @date： Created on 2020/11/27 8:55
 * @version： v1.0
 * @modified By:
 */
public class FourSumCount_1127 {
    public static void main(String[] args) {
        int[] A = { 1, 2};
        int[] B = {-2,-1};
        int[] C = {-1, 2};
        int[] D = {0, 2};
       int result =   new FourSumCount_1127().fourSumCount(A,B,C,D);
        System.out.println(result);
    }
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer,Integer> countAB = new HashMap<>(16);
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                countAB.put(A[i]+B[j],countAB.getOrDefault(A[i]+B[j],0)+1);
            }
        }
        int ans = 0;
        for (int c : C) {
            for (int d : D) {
                ans += countAB.get(-c-d) == null? 0:countAB.get(-c-d) ;
            }
        }
        return ans;
    }
}
