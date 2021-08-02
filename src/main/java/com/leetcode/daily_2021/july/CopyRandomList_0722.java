package com.leetcode.daily_2021.july;

import javax.sound.midi.Soundbank;
import java.util.HashMap;
import java.util.Map;

/**
 * @author： chenr
 * @date： Created on 2021/7/22 11:51
 * @version： v1.0
 * @modified By:
 */
public class CopyRandomList_0722 {
    public static void main(String[] args) {
        Node head1 = new Node(7);
        Node head2 = new Node(13);
        Node head3 = new Node(11);
        Node head4 = new Node(10);
        Node head5 = new Node(1);
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;

        head2.random = head1;
        head3.random = head5;
        head4.random = head3;
        head5.random = head1;
        Node node = new CopyRandomList_0722().copyRandomList(head1);
        while (node != null) {
            System.out.print(node.val+",");


            if (node.random != null) {
                System.out.print(node.random.val+" ");
            }else{
                System.out.print("null ");
            }
            node = node.next;
        }

    }
    Map<Node, Node> cachedNode = new HashMap<Node, Node>();
    public Node copyRandomList(Node head) {
        if(head == null) {
            return null;
        }
        if (!cachedNode.containsKey(head) ){
                Node headNew = new Node(head.val);
                cachedNode.put(head,headNew);
                headNew.next = copyRandomList(head.next);
                headNew.random = copyRandomList(head.random);
        }

        return cachedNode.get(head);
    }
}
