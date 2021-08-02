package com.leetcode.editor.title_daily;

import com.leetcode.editor.model.ListNode;

/**
 * @author： chenr
 * @date： Created on 2020/10/13 11:23
 * @version： v1.0
 * @modified By:
 */
public class SwapPairs_20201013 {
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
//        ListNode result =  new SwapPairs_20201013().swapPairs(listNode);
//        System.out.println(result.val);
        ListNode result =  new SwapPairs_20201013().swapPairs2(listNode);
        System.out.println(result.val);
    }
    public ListNode swapPairs(ListNode head) {
     if(head == null || head.next == null){
          return head;
      }
        ListNode temp = head.next;
        head.next = swapPairs(temp.next);
        temp.next =  head;
        return temp;
    }
    public ListNode swapPairs2(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp  = dummyHead;
        while(temp.next != null && temp.next.next != null){
            ListNode before = temp.next;
            ListNode after = temp.next.next;
            temp.next = after;
            before.next = after.next;
            after.next = before;
            temp = before;
        }
        return dummyHead.next;
    }
}
