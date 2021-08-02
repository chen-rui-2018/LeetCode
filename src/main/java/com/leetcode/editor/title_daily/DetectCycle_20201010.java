package com.leetcode.editor.title_daily;

import com.leetcode.editor.model.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author： chenr
 * @date： Created on 2020/10/10 14:00
 * @version： v1.0
 * @modified By:
 */
public class DetectCycle_20201010 {
    public static void main(String[] args) {
        ListNode listNode =  new ListNode(1);
        ListNode listNode1 =  new ListNode(2);
        ListNode listNode2=  new ListNode(3);
        ListNode listNode3 =  new ListNode(4);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
//        listNode3.next = listNode1;
      ListNode result =    new DetectCycle_20201010().detectCycle(listNode);
      ListNode result1 =    new DetectCycle_20201010().detectCycle(listNode);

        System.out.println(result == null? "链表无环" : result.val);
    }
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null){
            if (!set.add(head)){
                return head;
            }
            head = head.next;
        }
        return null;
    }
    // a+(n+1)b+nc=2(a+b)⟹a=c+(n−1)(b+c)
    public ListNode detectCycle1(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null){
            slow = slow.next;
            if(fast.next != null){
                fast = fast.next.next;
            } else {
                return  null;
            }
            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }

        }
        return null;
    }

}
