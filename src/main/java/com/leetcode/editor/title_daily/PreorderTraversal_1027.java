package com.leetcode.editor.title_daily;

import com.leetcode.editor.model.TreeNode;

import java.util.*;

/**
 * @author： chenr
 * @date： Created on 2020/10/27 10:51
 * @version： v1.0
 * @modified By:
 */
public class PreorderTraversal_1027 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(0);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;
        treeNode2.left = treeNode5;
        treeNode2.right = treeNode6;

//        List<Integer> ans =    new PreorderTraversal_1027().preorderTraversal3(treeNode);
        List<Integer> ans =    new PreorderTraversal_1027().midOrderTraversal(treeNode);
        System.out.println(Arrays.toString(ans.toArray()));
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans =  new ArrayList<>();
        dfs(root,ans);
        return ans;
    }

    private void dfs(TreeNode root, List<Integer> ans) {
        if (root == null){
            return;
        }
        ans.add(root.val);
        dfs(root.left,ans);
        dfs(root.right,ans);
    }
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> ans =  new ArrayList<>();
       if (root == null){
           return ans;
       }
        Deque<TreeNode> stack = new LinkedList<>();
       TreeNode node = root;
       while (!stack.isEmpty() || node !=null){
           while(node != null){
               ans.add(node.val);
               stack.push(node);
               node = node.left;
           }
           node = stack.pop();
           node = node.right;
       }
        return ans;
    }
    public List<Integer> preorderTraversal3(TreeNode root) {
        List<Integer> ans =  new ArrayList<>();
       if (root == null){
           return ans;
       }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            ans.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }


        return ans;
    }
    public List<Integer> midOrderTraversal(TreeNode head){

        List<Integer> ans =  new ArrayList<>();

        if (head == null) {
            return ans;
        }
        TreeNode cur = head;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            ans.add(node.val);
            System.out.print(node.val + " ");
            if (node.right != null) {
                cur = node.right;
            }
        }

    return ans;


    }

}
