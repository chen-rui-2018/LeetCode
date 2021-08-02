package com.leetcode.editor.title_daily;

import com.leetcode.editor.model.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author： chenr
 * @date： Created on 2020/10/15 9:23
 * @version： v1.0
 * @modified By:
 */
public class Connect_20201015 {
    public static void main(String[] args) {
        Node n1= new Node(1);
        Node n2= new Node(2);
        Node n3= new Node(3);
        Node n4= new Node(4);
        Node n5= new Node(5);
        Node n7= new Node(6);
        Node n8= new Node(7);


        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n7;
        n3.right = n8;

//        new Solution_20200928().connect(n1);
//        System.out.println(n5.next.val);
//     Node node=   new Connect_20201015().connect2(n1);
     Node node=   new Connect_20201015().connect3(n1);
//     Node node=   new Connect_20201015().connect(n1);
        System.out.println(n5.next.val);
    }

    private Node connect3(Node root) {
        if (root == null) {
            return root;
        }
        if (root.left != null) {
            root.left.next = root.right;
            if (root.next != null) {
                root.right.next = root.next.left;
            }
            connect3(root.left);
            connect3(root.right);
        }
        return root;
    }



    private Node connect2(Node root) {
        if (root == null ) {
            return root;
        }
        Node cur = root;
        while (cur != null ) {
            Node dummy = new Node(0);
            Node pre = dummy;
            while (cur != null) {
                if (cur.left != null) {
                    pre.next = cur.left;
                    pre = pre.next;
                }
                if (cur.right != null) {
                    pre.next = cur.right;
                    pre = pre.next;
                }
                cur = cur.next;
            }
            cur = dummy.next;
        }
        return root;
    }

    public Node connect(Node root) {
        if (root == null ) {
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            Node last = null;
            for (int i = 0; i < queueSize; i++) {
                Node f = queue.poll();
                if(f.left != null){
                    queue.offer(f.left);
                }
                if(f.right != null){
                    queue.offer(f.right);
                }
                if (i != 0) {
                    last.next = f;
                }
               last = f;
            }
        }
        return root;
    }
}
