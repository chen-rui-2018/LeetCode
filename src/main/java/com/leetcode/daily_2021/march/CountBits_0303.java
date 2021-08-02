package com.leetcode.daily_2021.march;

/**
 * @author： chenr
 * @date： Created on 2021/3/3 9:15
 * @version： v1.0
 * @modified By:
 */
public class CountBits_0303 {
    public static void main(String[] args) {
       int [] result =  new CountBits_0303().countBits(15);
        for (int i : result) {
            System.out.print(i+",");
        }
    }
    public int[] countBits1(int num) {
        int [] result = new int[num+1];
        for (int i = 0; i <= num; i++) {
            int count = 0;
            int temp = i;
            while (temp > 0) {
                count++;
                temp &= (temp-1);
            }
            result[i] = count;
        }

        return result;
    }
    public int[] countBits(int num) {
        int [] result = new int[num+1];
        int highBit = 0;
        for (int i = 1; i <= num; i++) {
           if ((i&(i-1)) == 0) {
                highBit = i;
           }
           result[i] = result[i-highBit] + 1;
        }

        return result;
    }
}
