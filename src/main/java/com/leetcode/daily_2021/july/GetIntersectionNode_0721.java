package com.leetcode.daily_2021.july;

import com.leetcode.editor.model.ListNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author： chenr
 * @date： Created on 2021/7/21 10:48
 * @version： v1.0
 * @modified By:
 */
public class GetIntersectionNode_0721 {
    public static void main(String[] args) {
        ListNode headA = new ListNode(4);
        ListNode headA1 = new ListNode(1);


        ListNode headB = new ListNode(5);
        ListNode headB0 = new ListNode(0);
        ListNode headB1 = new ListNode(1);

        ListNode headC1 = new ListNode(8);
        ListNode headC2 = new ListNode(4);
        ListNode headC3 = new ListNode(5);

        headC1.next = headC2;
        headC2.next = headC3;

        headA.next = headA1;
        headA1.next = headC1;
        headB.next = headB0;
        headB0.next = headB1;
        headB1.next = headC1;

        ListNode intersectionNode = new GetIntersectionNode_0721().getIntersectionNode(headA, headB);
        System.out.println(intersectionNode.val);
    }

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        Map<Integer, Integer> map = new HashMap<>();
        ListNode head = headA;
        while (head != null) {
            int num = map.getOrDefault(head.val, 0) + 1;
            map.put(head.val, num);
            head = head.next;
        }
        head = headB;
        ListNode ret = null;
        while (head != null) {
            if (map.containsKey(head.val)) {
                ret = head;
                break;
            }
            head = head.next;
        }
        return ret;
    }
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        Set<ListNode> visited = new HashSet<ListNode>();
        ListNode temp = headA;
        while (temp != null) {
            visited.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while (temp != null) {
            if (visited.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;

    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
       if ( headA == null || headB == null){
           return null;
       }
       ListNode HA= headA,HB = headB;
       while (HA != HB) {
           HA = HA == null ? headB : HA.next;
           HB = HB == null ? headA : HB.next;
       }
        return HA;
    }
}
