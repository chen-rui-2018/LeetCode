package com.leetcode.editor.title_daily;

import com.leetcode.editor.model.ListNode;

/**
 * @author： chenr
 * @date： Created on 2020/10/20 17:00
 * @version： v1.0
 * @modified By:
 */
public class ReorderList_20201020 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(0);
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        new ReorderList_20201020().reorderList(listNode);
//        new ReorderList_20201020().reverseList(listNode);
        System.out.println();
    }
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next ==null){
            return;
        }
        ListNode slowp =head ;
        ListNode fastp =head ;
        while(fastp.next != null && fastp.next.next !=null){
            slowp = slowp.next;
            fastp = fastp.next.next;
        }
        ListNode newHead = slowp.next;
        slowp.next = null;
        newHead = reverseList(newHead);
        while(newHead != null){
            ListNode temp = newHead.next;
            newHead.next = head.next;
            head.next = newHead;
            head = newHead.next;
            newHead = temp;
        }
    }

    private ListNode reverseList(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode tail = head;
        head = head.next;
        tail.next = null;
        while (head != null){
            ListNode temp =head.next;
            head.next = tail;
            tail = head;
            head = temp;
        }
        return tail;
    }
}
