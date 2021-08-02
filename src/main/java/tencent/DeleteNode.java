package tencent;

import tencent.model.ListNode;

/**
 * @author： chenr
 * @date： Created on 2021/1/19 16:50
 * @version： v1.0
 * @modified By:
 *
 */
public class DeleteNode {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(4);
        ListNode listNode1 = new ListNode(5);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(8);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;

        new  DeleteNode().deleteNode(listNode1);
        while(listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;

    }

}
