package com.leetcode.editor.model;

/**
 * @author： chenr
 * @date： Created on 2020/9/21 16:46
 * @version： v1.0
 * @modified By:
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x){val=x;}
    public TreeNode(int x,TreeNode left,TreeNode right){
        this.val=x;
        this.left =left;
        this.right =right;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}
