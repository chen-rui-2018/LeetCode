package tencent;

import tencent.model.ListNode;

import java.util.PriorityQueue;

/**
 * @author： chenr
 * @date： Created on 2021/1/29 14:21
 * @version： v1.0
 * @modified By:
 */
public class MergeKLists {
    public static void main(String[] args) {
        ListNode root1 = new ListNode(-2);
        ListNode node12 = new ListNode(-1);
        ListNode node13 = new ListNode(-1);
        ListNode node14 = new ListNode(-1);

        ListNode root2 = new ListNode(1);
        ListNode node22 = new ListNode(2);
        ListNode node23 = new ListNode(3);
        ListNode root3 = new ListNode(1);
        ListNode node32 = new ListNode(2);
        ListNode node33 = new ListNode(3);
        root1.next = node12;
        node12.next = node13;
        node13.next = node14;

        root2.next = node22;
        node22.next = node23;
        root3.next = node32;
        node32.next = node33;
        ListNode[] lists = {root1,null};

        ListNode result =   new MergeKLists().mergeKLists(lists);
        while (result != null){
            System.out.print(result.val + " , ");
            result = result.next;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> queue = new PriorityQueue<>((o1,o2)->(o1.val-o2.val));
        for (ListNode node : lists) {
            while(node != null){
                queue.offer(new ListNode(node.val));
                node = node.next;
            }
        }
        ListNode ans = new ListNode(0);
        ListNode temp = ans;
        while (!queue.isEmpty()){
            temp.next = queue.poll();
            temp = temp.next;
        }
        return ans.next;
    }
}
