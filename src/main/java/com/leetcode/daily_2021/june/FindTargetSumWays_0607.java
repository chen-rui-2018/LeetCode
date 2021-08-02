package com.leetcode.daily_2021.june;

/**
 * @author： chenr
 * @date： Created on 2021/6/7 9:04
 * @version： v1.0
 * @modified By:
 */
public class FindTargetSumWays_0607 {
    public static void main(String[] args) {
        int[] nums= {1,1,1,1,1};
        int target = 3;
        int targetSumWays = new FindTargetSumWays_0607().findTargetSumWays(nums, target);
        System.out.println(targetSumWays);
    }


    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int diff = sum - target;
        if (diff < 0 || diff % 2 != 0 ){
            return  0;
        }
        int n = nums.length, neg = diff / 2;
        int [][] dp = new int[n+1][neg+1];
        dp[0][0] = 1;
        for(int i = 1; i <= n; i++){
            int num = nums[i-1];
            for (int j = 0; j <= neg ; j++) {
                dp[i][j] = dp[i-1][j];
                if (j >= num) {
                    dp[i][j] += dp[i-1][j-num];
                }
            }
        }
        return dp[n][neg];
    }


    int count = 0;
    public int findTargetSumWays1(int[] nums, int target) {
        backtrack(nums,target,0,0);
        return count;
    }

    private void backtrack(int[] nums, int target, int index, int sum) {
        if (index == nums.length) {
            if ( sum == target){
                count++;
            }
        }else {
            backtrack(nums,target,index+1,sum+nums[index]);
            backtrack(nums,target,index+1,sum-nums[index]);
        }
    }


}
