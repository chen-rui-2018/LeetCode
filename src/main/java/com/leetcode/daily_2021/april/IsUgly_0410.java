package com.leetcode.daily_2021.april;

/**
 * @author： chenr
 * @date： Created on 2021/4/11 21:58
 * @version： v1.0
 * @modified By:
 */
public class IsUgly_0410 {
    public static void main(String[] args) {
       boolean result =  new IsUgly_0410().isUgly(14);
        System.out.println(result);

    }

    public boolean isUgly(int n) {
        if (n <= 0){
            return false;
        }
        int [] params  = {2,3,5};
        for (int param : params) {
            while ((n % param) == 0) {
                n /= param;
            }
        }
        return n==1;

    }
}
