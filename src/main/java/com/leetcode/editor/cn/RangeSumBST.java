package com.leetcode.editor.cn;

import com.leetcode.editor.model.TreeNode;

import java.util.Stack;

/**
 * @author： chenr
 * @date： Created on 2020/11/10 10:56
 * @version： v1.0
 * @modified By:
 */
public class RangeSumBST {
    public static void main(String[] args) {

    }
    int ans;
    public int rangeSumBST(TreeNode root, int low, int high) {
        ans = 0;
        dfs(root,low,high);
        return ans;
    }

    private void dfs(TreeNode root, int low, int high) {
        if (root != null) {
            if(root.val >= low && root.val <= high ) {
                ans += root.val;
            }
            if (root.left != null && low < root.val){

                dfs(root.left,low,high);
            }
            if (root.right != null && root.val < high){
                dfs(root.right,low,high);
            }
        }
    }
    public int rangeSumBST2(TreeNode root, int low, int high) {
         int result  = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while( !stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node != null){
                if (low < node.val){
                    stack.push(node.left);
                }
                if(high > node.val) {
                    stack.push(node.right);
                }
                if (low <= node.val && high >= node.val){
                    result += node.val;
                }
            }
        }
        return result;
    }
}
