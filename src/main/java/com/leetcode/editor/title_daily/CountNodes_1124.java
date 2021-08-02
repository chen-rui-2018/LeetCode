package com.leetcode.editor.title_daily;

import com.leetcode.editor.model.TreeNode;

/**
 * @author： chenr
 * @date： Created on 2020/11/24 10:22
 * @version： v1.0
 * @modified By:
 */
public class CountNodes_1124 {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node.left = node1;
        node.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
//        node3.left = node7;
        System.out.println( new CountNodes_1124().countNodes(node));
    }
    int num = 0;
    public int countNodes(TreeNode root) {
         dfs(root);
        return num;
    }

    private void  dfs(TreeNode root) {
        if(root != null){
            num++;
            if (root.left!=null){
                dfs(root.left);
            }
            if(root.right != null){
                dfs(root.right);
            }
        }

    }
    public int countNodes2(TreeNode root) {
       if (root == null){
           return 0;
       }
       int left = countLevel(root.left);
       int right = countLevel(root.right);
       if (left == right){
           return countNodes(root.right) +(1<<left);
       }else {
           return countNodes(root.left) +(1<<right);
       }
    }
    private int countLevel(TreeNode root) {
        int level = 0;
        while (root != null){
            level ++;
            root = root.left;
        }
        return level;
    }

}
