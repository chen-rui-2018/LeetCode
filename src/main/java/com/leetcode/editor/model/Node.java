package com.leetcode.editor.model;

/**
 * @author： chenr
 * @date： Created on 2020/9/28 9:33
 * @version： v1.0
 * @modified By:
 */
public class Node {

        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }
        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
}
