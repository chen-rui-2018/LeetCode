package com.leetcode.daily_2021.june;

/**
 * @author： chenr
 * @date： Created on 2021/6/24 9:14
 * @version： v1.0
 * @modified By:
 */
public class HammingWeight_0623 {
    public static void main(String[] args) {
        int i = new HammingWeight_0623().hammingWeight(9);
        System.out.println(i);
    }
    public int hammingWeight1(int n) {
        return Integer.bitCount(n);
    }
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0){
            n &= n-1;
            res++;
        }
        return res;
    }

}
