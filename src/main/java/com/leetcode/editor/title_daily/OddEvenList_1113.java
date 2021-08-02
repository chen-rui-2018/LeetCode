package com.leetcode.editor.title_daily;

import com.leetcode.editor.model.ListNode;

import java.awt.*;

/**
 * @author： chenr
 * @date： Created on 2020/11/13 9:19
 * @version： v1.0
 * @modified By:
 */
public class OddEvenList_1113 {
    public static void main(String[] args) {
        ListNode node = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode temp = node;
        while (temp != null){
            System.out.print(temp.val + ", ");
            temp = temp.next;
        }
        System.out.println();
        ListNode result =  new OddEvenList_1113().oddEvenList(node);

        while (result != null){
            System.out.print(result.val + ", ");
            result = result.next;
        }

    }
    public ListNode oddEvenList(ListNode head) {
        if (head == null){
            return head;
        }
        ListNode evenHead = head.next;
        ListNode odd = head;
        ListNode even = evenHead;
        while (even != null  && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
