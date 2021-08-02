package com.leetcode.daily_2021.march;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author： chenr
 * @date： Created on 2021/3/8 10:23
 * @version： v1.0
 * @modified By:
 */
public class NextGreaterElements_0305 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 1, 1, 4};
        int[] res = new NextGreaterElements_0305().nextGreaterElements(nums);
        for (int re : res) {
            System.out.print(re + ",");
        }
    }

    public int[] nextGreaterElements(int[] nums) {
        int length = nums.length;
        int[] res = new int[length];
        Arrays.fill(res, -1);
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < 2 * length - 1; i++) {
            while (!deque.isEmpty() && nums[i % length] > nums[deque.peek()]) {
                res[deque.pop()] = nums[i % length];
            }
            deque.push(i % length);

        }
        return res;
    }
}

