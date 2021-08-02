package com.leetcode.daily_2021.february;

import java.util.*;

/**
 * @author： chenr
 * @date： Created on 2021/2/22 9:14
 * @version： v1.0
 * @modified By:
 */
public class LongestSubarray_0221 {
    public static void main(String[] args) {
        int[] nums = {10,1,2,4,7,2};
        int limit = 5;
            int result = new LongestSubarray_0221().longestSubarray(nums,limit);
        System.out.println(result);
    }
    public int longestSubarray(int[] nums, int limit) {
        int left = 0;
        int right = 0;
        int maxLong = 0;
        int length = nums.length;
        Deque<Integer> minQueue = new LinkedList<>();
        Deque<Integer> maxQueue = new LinkedList<>();
        while (right < length) {
           while ( !maxQueue.isEmpty() && maxQueue.peekLast() < nums[right]) {
               maxQueue.pollLast();
           }
           while ( !minQueue.isEmpty() && minQueue.peekLast() > nums[right]) {
               minQueue.pollLast();
           }
           minQueue.offerLast(nums[right]);
           maxQueue.offerLast(nums[right]);
           while ( !minQueue.isEmpty() && !maxQueue.isEmpty() && maxQueue.peekFirst() - minQueue.peekFirst() > limit){
               if (nums[left] == minQueue.peekFirst()) {
                   minQueue.pollFirst();
               }
               if(nums[left] == maxQueue.peekFirst()) {
                   maxQueue.pollFirst();
               }
               left++;
           }
           maxLong = Math.max(maxLong,right - left + 1);
           right++;
        }
        return maxLong;
    }

}
