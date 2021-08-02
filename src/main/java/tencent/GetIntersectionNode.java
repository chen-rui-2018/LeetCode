package tencent;

import tencent.model.ListNode;

/**
 * @author： chenr
 * @date： Created on 2021/2/19 15:55
 * @version： v1.0
 * @modified By:
 */
public class GetIntersectionNode {
    public static void main(String[] args) {

    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null  ||  headB == null) {
            return null;
        }
        ListNode pA = headA;
        ListNode pB = headB;
        while ( pA != pB){
          pA  =  pA == null ? headB : pA.next;
          pB  =  pB == null ? headA : pB.next;
        }
        return pA;

    }
}
