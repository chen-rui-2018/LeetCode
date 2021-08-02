package com.leetcode.daily_2021.april;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author： chenr
 * @date： Created on 2021/4/2 9:07
 * @version： v1.0
 * @modified By:
 */
public class Clumsy_0401 {
    public static void main(String[] args) {
      int result =   new Clumsy_0401().clumsy(10);
        System.out.println(result);
    }

    public int clumsy(int N) {
        int index = 0;
        int result = 0;
        Deque<Integer> deque = new LinkedList<>();
        deque.push(N);
        for (int i = N-1; i  > 0 ; i--) {
            if (index == 0) {
                deque.push(deque.pop() * i);
            }
            if (index == 1) {
                deque.push(deque.pop() / i);
            }
            if (index == 2) {
                deque.push( i);
            }
            if (index == 3) {
                deque.push(-i);
            }
            index = (index + 1) % 4;
        }
        while ( !deque.isEmpty()){
            result += deque.pop();
        }
        return result;
    }
}
