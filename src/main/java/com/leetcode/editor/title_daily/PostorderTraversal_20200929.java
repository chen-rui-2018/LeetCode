package com.leetcode.editor.title_daily;

import com.leetcode.editor.model.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author： chenr
 * @date： Created on 2020/9/29 9:56
 * @version： v1.0
 * @modified By:
 */
public class PostorderTraversal_20200929 {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n1.right = n3;
        n1.left = n2;

        List<Integer> list =   new PostorderTraversal_20200929().postorderTraversal(n1);
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root,list);
        return list;
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if(root != null){
            dfs(root.left,list);
            dfs(root.right,list);
            list.add(root.val);
        }
    }

    public List<Integer> postorderTraversal2(TreeNode root){
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(root.right == null || root.right == prev) {
                res.add(root.val);
                prev = root;
                root = null;
            }else {
                stack.push(root);
                root = root.right;
            }
        }

        return res;
    }
}
