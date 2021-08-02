package com.leetcode;

/**
 * @author： chenr
 * @date： Created on 2021/7/4 10:37
 * @version： v1.0
 * @modified By:
 */
public class CountGoodNumbers {
    public static void main(String[] args) {
        int n = 4;
        int v = new CountGoodNumbers().countGoodNumbers(n);
        System.out.println(v);
        double v1 = Math.pow(10, 9) + 7;
        System.out.println(v1-1000000007);

    }
    public int countGoodNumbers(long n) {
        int arr1 =  4;
        int arr2 = 5 ;
        if (n == 1) {
            return arr2;
        }
        double result = 1;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                result *= 5;
            }else if (i%2 == 0) {
                result *= arr2;
            }else {
                result *= arr1;
            }
//            if (result % 1000000007 == 0) {
//                result = 1;
//            }
        }
        return (int)(result %(Math.pow(10,9)+7));

    }
}
