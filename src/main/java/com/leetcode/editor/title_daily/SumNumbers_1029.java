package com.leetcode.editor.title_daily;

import com.leetcode.editor.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author： chenr
 * @date： Created on 2020/10/29 21:14
 * @version： v1.0
 * @modified By:
 */
public class SumNumbers_1029 {
    public static void main(String[] args) {

    }
    public int sumNumbers(TreeNode root) {
        return dfs(root,0);
    }

    private int dfs(TreeNode root, int i) {
        if(root== null){
            return 0;
        }
        int sum = i * 10 + root.val;
         if(root.left == null && root.right == null){
             return sum;
         }else {
             return dfs(root.left,sum)+ dfs( root.right,sum);
         }

    }
    public int sumNumbers2(TreeNode root) {
        if(root== null){
            return 0;
        }
        int sum = 0;
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> numQueue = new LinkedList<>();
        nodeQueue.offer(root);
        numQueue.offer(root.val);
        while(!nodeQueue.isEmpty()){
            TreeNode node = nodeQueue.poll();
            int num = numQueue.poll();
            TreeNode left = node.left;
            TreeNode right = node.right;
            if(left == null && right == null){
                sum += num;
            }else{
                if(left != null){
                    nodeQueue.offer(node.left);
                    numQueue.offer(num * 10 + left.val);
                }
                if(right != null){
                    nodeQueue.offer(node.right);
                    numQueue.offer(num * 10 + right.val);
                }
            }
        }
        return sum;
    }
}
