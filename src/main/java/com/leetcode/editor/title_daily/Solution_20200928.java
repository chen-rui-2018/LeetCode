package com.leetcode.editor.title_daily;

import com.leetcode.editor.model.Node;

import javax.sound.midi.Soundbank;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author： chenr
 * @date： Created on 2020/9/28 9:36
 * @version： v1.0
 * @modified By:
 */
public class Solution_20200928 {

    public static void main(String[] args) {
        Node n1= new Node(1);
        Node n2= new Node(2);
        Node n3= new Node(3);
        Node n4= new Node(4);
        Node n5= new Node(5);
        Node n7= new Node(6);
        Node n8= new Node(7);

        n1.val = 1;
        n1.left = n2;
        n1.right = n3;
        n2.val = 2;
        n2.left = n4;
        n2.right = n5;
        n4.val = 4;
        n5.val = 5;
        n3.val = 3;
        n3.right = n7;
        n7.val = 7;
//        new Solution_20200928().connect(n1);
//        System.out.println(n5.next.val);
        new Solution_20200928().connect2(n1);
        System.out.println(n5.next.val);
}
    public Node connect(Node root) {
        if(root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int n = queue.size();
            Node last =null;
            for (int i = 1; i <= n; i++) {
                Node f = queue.poll();
                if(f.left != null){
                    queue.offer(f.left);
                }
                if(f.right != null ){
                    queue.offer(f.right);
                }
                if(i != 1){
                    last.next = f;
                }
                last = f;
            }
        }
        return root;
    }
    public Node connect2(Node root) {
        if(root == null) {
            return null;
        }
        // cur 我们可以把它看做是每一层的链表
        Node cur = root;
        while(cur != null){
            //遍历当前层的时候，为了方便操作在下一
            //层前面添加一个哑结点（注意这里是访问
            //当前层的节点，然后把下一层的节点串起来）
            Node dummy = new Node(0);
            //pre表示访下一层节点的前一个节点
            Node pre = dummy;
            while(cur != null){
                if(cur.left != null){
                    //如果当前节点的左子节点不为空，就让pre节点
                    //的next指向他，也就是把它串起来
                    pre.next = cur.left;
                    //然后再更新pre
                    pre =  pre.next;
                }
                if(cur.right != null){
                    pre.next = cur.right;
                    pre = pre.next;
                }
                cur = cur.next;
            }
            //把下一层串联成一个链表之后，让他赋值给cur，
            //后续继续循环，直到cur为空为止
            cur = dummy.next;
        }
        return  root;

    }
}
