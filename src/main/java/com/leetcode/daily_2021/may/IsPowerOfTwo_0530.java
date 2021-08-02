package com.leetcode.daily_2021.may;

/**
 * @author： chenr
 * @date： Created on 2021/6/3 14:07
 * @version： v1.0
 * @modified By:
 */
public class IsPowerOfTwo_0530 {
    public static void main(String[] args) {
        boolean powerOfTwo = new IsPowerOfTwo_0530().isPowerOfTwo(1);
        System.out.println(powerOfTwo);
    }
    public boolean isPowerOfTwo(int n) {
        return (n > 0) && ((n & (n-1)) == 0)  ;
    }
}
