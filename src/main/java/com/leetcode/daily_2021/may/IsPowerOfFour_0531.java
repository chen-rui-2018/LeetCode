package com.leetcode.daily_2021.may;

/**
 * @author： chenr
 * @date： Created on 2021/6/3 13:48
 * @version： v1.0
 * @modified By:
 */
public class IsPowerOfFour_0531 {

    public static void main(String[] args) {

    }
    public boolean isPowerOfFour(int n) {
      return (n > 0) && ((n & (n-1)) ==0 ) && ((n % 3 == 1));
    }

}
