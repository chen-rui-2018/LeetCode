package com.leetcode.daily_2021.february;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author： chenr
 * @date： Created on 2021/2/18 16:21
 * @version： v1.0
 * @modified By:
 */
public class KthLargest {
    public static void main(String[] args) {
        int [] nums = {4, 5, 8, 2};
        KthLargest kthLargest =  new KthLargest(3,nums);
        System.out.println( kthLargest.add(3));
    }
    PriorityQueue<Integer> queue;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.queue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            add(nums[i]);
        }

    }
    public int add(int val) {
        queue.offer(val);
        if (queue.size() > k){
            queue.poll();
        }
        return queue.peek();
    }
}
