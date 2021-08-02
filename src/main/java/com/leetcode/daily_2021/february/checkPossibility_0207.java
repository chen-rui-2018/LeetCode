package com.leetcode.daily_2021.february;

/**
 * @author： chenr
 * @date： Created on 2021/2/7 9:10
 * @version： v1.0
 * @modified By:
 */
public class checkPossibility_0207 {
    public static void main(String[] args) {
        int[] nums = {3,4,2,3};
       boolean result =  new checkPossibility_0207().checkPossibility(nums);
        System.out.println(result);
    }
    public boolean checkPossibility(int[] nums) {
        int pre = 0;
        int next = 1;
        int count  = 0 ;
        while (next < nums.length){

            if (nums[next] < nums[pre]) {
                count++;
                if (pre > 0 && nums[next] < nums[pre-1]) {
                    nums[next] = nums[pre];
                }
            }
            if (count > 1){
                return false;
            }
            pre++;
            next++;
        }
        return true;
    }
}
