package com.leetcode.daily_2021.february;

/**
 * @author： chenr
 * @date： Created on 2021/2/23 9:33
 * @version： v1.0
 * @modified By:
 */
public class MaxSatisfied_0223 {
    public static void main(String[] args) {
        int [] customers  = {1,0,1,2,1,1,7,5};
        int [] grumpy  =    {0,1,0,1,0,1,0,1};
        int x = 3;


        int result = new MaxSatisfied_0223().maxSatisfied(customers,grumpy,x);
        System.out.println(result);
    }
    public int maxSatisfied1(int[] customers, int[] grumpy, int X) {
        int count = 0;
        int maxCount = 0;
        int result = 0;
        int left = 0;
        int right = 0;
        int length = customers.length;
        while (right < length) {
            if (grumpy[right] == 0) {
                result += customers[right];
            }else {
                count += customers[right];
            }

            if (right - left > X-1) {
                if (grumpy[left] == 1  && grumpy[right] == 1 ) {
                    count -= customers[left];
                }
                maxCount = Math.max(count,maxCount);
                left++;
            }
            right++;
        }

        return result + maxCount;
    }
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {

        int result = 0;
        int length = customers.length;
        for (int i = 0; i < length; i++) {
            if (grumpy[i] == 0) {
                result += customers[i];
            }
        }
        int count = 0;
        for (int i = 0; i < X; i++) {
            count += customers[i] * grumpy[i];
        }
        int maxCount = count;
        for (int i = X; i < length; i++) {
            count = count - customers[i - X] * grumpy[i - X] + customers[i] * grumpy[i];
            maxCount = Math.max(maxCount,count);
        }
        return result + maxCount;
    }
}
