package com.leetcode.daily_2021.june;

import com.leetcode.editor.model.ListNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author： chenr
 * @date： Created on 2021/6/4 9:08
 * @version： v1.0
 * @modified By:
 */
public class GetIntersectionNode_0604 {
    public static void main(String[] args) {

    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>(16);
        ListNode temp = headA;
        while (temp != null){
            set.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while (temp != null){
            if (set.contains(temp)) {
               return temp;
           }
           temp =temp.next;
        }
        return null;
    }
}
