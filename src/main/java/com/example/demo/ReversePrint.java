package com.example.demo;

import com.leetcode.editor.model.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author： chenr
 * @date： Created on 2021/1/4 14:23
 * @version： v1.0
 * @modified By:
 */
public class ReversePrint {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        node1.next = node3;
        node3.next = node2;
       int [] ans =   new ReversePrint().reversePrint(node1);
        System.out.println(Arrays.toString(ans));
    }
    public int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int [] ans = new int [list.size()];
        int index = 0;
        for(int i=list.size()-1; i >= 0; i--){
            ans[index] = list.get(i);
            index++;
        }

        Stack<ListNode> stack = new Stack<>();

        return ans;
    }
}
