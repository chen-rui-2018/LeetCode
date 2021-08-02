package com.leetcode.editor.title_daily;

import com.leetcode.editor.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author： chenr
 * @date： Created on 2020/10/12 10:12
 * @version： v1.0
 * @modified By:
 */
public class MinimumDifference20201012 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode.right = treeNode3;
        treeNode3.left = treeNode2;
        System.out.println( new MinimumDifference20201012().getMinimumDifference1(treeNode));
    }
    public int getMinimumDifference1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs1(root,list);
        int j = 1;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < list.size()-1; i++) {
            int result = list.get(j)- list.get(i);
            ans = result < ans ? result : ans;
            j++;
        }
        return ans;
    }

    private void dfs1(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        dfs1(root.left,list);
        list.add(root.val);
        dfs1(root.right,list);
    }
    int pre;
    int ans;

    public int getMinimumDifference(TreeNode root){
        ans = Integer.MAX_VALUE;
        pre = -1;
        dfs(root);
        return ans;
    }
    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre == -1){
           pre =   root.val;

        }else {
            ans = Math.min(ans,root.val - pre);
            pre = root.val;
        }

        dfs(root.right);
    }

}
