package com.leetcode.daily_2021.april;

/**
 * @author： chenr
 * @date： Created on 2021/4/2 9:52
 * @version： v1.0
 * @modified By:
 */
public class Trap_0402 {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
       int result =  new Trap_0402().trap(height);
        System.out.println(result);
    }
    public int trap1(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0;
        }
        int [] leftMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i-1],height[i]);
        }
        int[] rightMax = new int[n];
        rightMax[n-1] = height[n-1];
        for (int i = n-2; i >=0 ; i--) {
            rightMax[i] = Math.max(rightMax[i+1],height[i]);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += Math.min(leftMax[i],rightMax[i])-height[i];
        }
        return res;
    }
    //双指针
    public int trap(int[] height) {
        int ans = 0;
        int left = 0,right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax,height[left]);
            rightMax = Math.max(rightMax,height[right]);
            if (height[left] < height[right]){
                ans += leftMax - height[left];
                left++;
             }else {
                ans += rightMax - height[right];
                --right;
            }
        }
        return ans;
    }
}
