package com.leetcode.daily_2021.march;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author： chenr
 * @date： Created on 2021/3/9 9:25
 * @version： v1.0
 * @modified By:
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        System.out.println( new RemoveDuplicates().removeDuplicates("abbaca"));
    }
    public String removeDuplicates1(String S) {
        char[] chars = S.toCharArray();
        Deque<Character> stack = new LinkedList<>();
        for (char item : chars) {
            if (!stack.isEmpty() && stack.peek() == item){
                stack.pop();
                continue;
            }
            stack.push(item);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.removeLast());
        }
        return sb.toString();
    }
    // 最优时间和空间
    public String removeDuplicates2(String S) {
        char[] chars = S.toCharArray();
        StringBuilder stack = new StringBuilder();
        int index = -1;
        for (char item : chars) {
            if (index >=0 && stack.charAt(index) == item){
                stack.deleteCharAt(index);
                index--;
            }else {
                stack.append(item);
                index++;
            }
        }
        return stack.toString();
    }
    public String removeDuplicates(String S) {
        StringBuilder stack = new StringBuilder();
        int index = -1;
        for (int i = 0; i < S.length(); i++) {
            char item = S.charAt(i);
            if (index >=0 && stack.charAt(index) == item){
                stack.deleteCharAt(index);
                index--;
            }else {
                stack.append(item);
                index++;
            }
        }
        return stack.toString();
    }
}
