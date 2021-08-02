package com.leetcode.daily_2021.march;

import java.util.Deque;
import java.util.Stack;

/**
 * @author： chenr
 * @date： Created on 2021/3/5 9:19
 * @version： v1.0
 * @modified By:
 */
public class MyQueue_0305 {
    class MyQueue {
        Stack<Integer> pre;
        Stack<Integer> next;

        public MyQueue() {
            pre = new Stack<>();
            next = new Stack<>();
        }

        public void push(int x) {
            while (!next.isEmpty()) {
                pre.push(next.pop());
            }
            pre.push(x);
        }

        public int pop() {
            while (!pre.isEmpty()) {
                next.push(pre.pop());
            }
            return next.pop();
        }

        public int peek() {
            while (!pre.isEmpty()) {
                next.push(pre.pop());
            }
            return next.peek();
        }

        public boolean empty() {
            return pre.isEmpty() && next.isEmpty();
        }
    }
}
