package tencent.model;

/**
 * @author： chenr
 * @date： Created on 2021/1/19 16:51
 * @version： v1.0
 * @modified By:
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x){
        val = x;
    }
    public ListNode(int x,ListNode next){
        this.val = x;
        this.next = next;
    }


}
