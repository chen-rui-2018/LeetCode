package com.leetcode.editor.title_daily;

import com.leetcode.editor.model.ListNode;

/**
 * @author： chenr
 * @date： Created on 2020/11/20 9:20
 * @version： v1.0
 * @modified By:
 */
public class InsertionSortList_1120 {
    public static void main(String[] args) {
        ListNode node = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(8);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(5);

        node5.next = node4;
        node4.next = node3;
        node3.next = node2;
        node2.next = node1;
        node1.next = node;
        node.next = node6;

        ListNode template = node5;
        while (template != null){
            System.out.print(template.val + ", ");
            template = template.next;
        }
        System.out.println();
        ListNode result =  new InsertionSortList_1120().insertionSortList2(node5);
        while (result != null){
            System.out.print(result.val + ", ");
            result = result.next;
        }
    }
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head .next == null){
            return head;
        }
        ListNode ans = new ListNode(99);
        ListNode result = ans;
        ListNode pre = head.next;
        ans.next = new ListNode(head.val);
        while(pre != null){
            ListNode temp  = new ListNode(pre.val);
            ans = result;
            while(ans.next != null && temp != null) {
                if (ans.next.val >= temp.val) {
                    temp.next = ans.next;
                    ans.next = temp;
                    break;
                }else if (ans.next.val < temp.val && ans.next.next == null){
                    ans.next.next = new ListNode(temp.val);
                    break;
                }else{
                    ans =ans.next;
                }
            }
            pre= pre.next;
        }
        return result.next;
    }

    public ListNode insertionSortList2(ListNode head) {

        if(head == null || head .next == null){
            return head;
        }
        ListNode dumHead = new ListNode(0);
        dumHead.next = head;
        ListNode lastSorted = head;
        ListNode curr = head.next;
        while (curr != null){
            if(lastSorted.val <= curr.val){
                lastSorted = lastSorted.next;
            }else{
                ListNode prev = dumHead;
                while (prev.next.val <= curr.val){
                    prev =prev.next;
                }
                lastSorted.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            }
            curr = lastSorted.next;
        }
        return  dumHead.next;
    }
}
