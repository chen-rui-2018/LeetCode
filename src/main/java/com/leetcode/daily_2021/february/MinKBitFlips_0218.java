package com.leetcode.daily_2021.february;

/**
 * @author： chenr
 * @date： Created on 2021/2/18 9:26
 * @version： v1.0
 * @modified By:
 */
public class MinKBitFlips_0218 {
    public static void main(String[] args) {
        int [] A = {0,0,0,1,0,1,1,0};
        int K = 3;
        int result =  new MinKBitFlips_0218().minKBitFlips(A,K);
        System.out.println(result);
    }

    public int minKBitFlips1(int[] A, int K) {
        int len = A.length;
        int res = 0;
        if (A == null || len <= 0) {
            return -1;
        }
        for (int i = 0; i < len; i++) {
            if (A[i] == 0) {
                if (i + K > len) {
                    return -1;
                }
                for (int j = i; j < i+K; j++) {
                    A[j] ^= 1;
                }
                res++;
            }

        }
        return res;
    }
    public int minKBitFlips(int[] A, int K) {
        if(A == null || A.length == 0){
            return 0;
        }
        int len = A.length;
        int curFlip = 0;
        int res = 0;
        for (int i = 0; i < len; i++) {
            
            if(i >= K && A[i-K] > 1 ){
                curFlip--;
                A[i-K] -= 2;
            }
            if (curFlip % 2 == 0 && A[i] == 0 || curFlip % 2 == 1 && A[i] == 1){
                if ( i + K > len){
                    return -1;
                }
                A[i] += 2;
                curFlip++;
                res++;
            }
        }
        return res;
    }
}
