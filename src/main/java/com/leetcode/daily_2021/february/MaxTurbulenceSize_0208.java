package com.leetcode.daily_2021.february;

/**
 * @author： chenr
 * @date： Created on 2021/2/8 9:56
 * @version： v1.0
 * @modified By:
 */
public class MaxTurbulenceSize_0208 {
    public static void main(String[] args) {
        int[] arr = {9,4,2,10,7,8,8,1,9};
        int result = new MaxTurbulenceSize_0208().maxTurbulenceSize(arr);
        System.out.println(result);
    }
    public int maxTurbulenceSize(int[] arr) {
        int length  = arr.length;
        if (length < 2){
            return length;
        }
        int [] increase = new int[length];
        int [] decrease = new int[length];
        increase[0] = 1;
        decrease[0] = 1;
        int res = 1;
        for (int i = 1; i < length; i++) {
            if ( arr[i-1] < arr[i]){
                increase[i] = decrease[i-1] + 1;
                decrease[i] = 1;
            }else if (arr[i-1] > arr[i]){
                decrease[i] = increase[i-1] + 1;
                increase[i] = 1;
            }else {
                decrease[i] = 1;
                increase[i] = 1;
            }
            res = Math.max(res,Math.max(decrease[i],increase[i]));
        }
        return res;

    }
}
