package com.leetcode.editor.title_daily;

import com.leetcode.editor.model.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;

/**
 * @author： chenr
 * @date： Created on 2020/10/9 9:28
 * @version： v1.0
 * @modified By:
 */
public class HasCycle_20201009 {
    public static void main(String[] args) {
        ListNode listNode =  new ListNode(1);
        ListNode listNode1 =  new ListNode(2);
        ListNode listNode2=  new ListNode(3);
        ListNode listNode3 =  new ListNode(4);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
//        listNode3.next = listNode1;
        System.out.println( new  HasCycle_20201009().hasCycle(listNode));
        System.out.println( new  HasCycle_20201009().hasCycle1(listNode));
    }
    // hash 表
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null){
            if (!set.add(head)){
                return true;
            }
            head = head.next;
        }
        return false;
    }
    // 快慢指针
    public boolean hasCycle1(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast){
            if (fast == null || fast.next == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
    public boolean isUnique(String astr) {
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        if (astr == null || astr =="") {
            return true;
        }
        char [] chars = astr.toCharArray();
        for(char c : chars){
            if(map.containsKey(c)) {
                return  false;
            }else {
                map.put(c,1);
            }

        }
        return true;
    }
}
