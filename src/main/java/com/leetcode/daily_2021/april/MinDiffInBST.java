package com.leetcode.daily_2021.april;

import com.leetcode.editor.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author： chenr
 * @date： Created on 2021/4/13 23:17
 * @version： v1.0
 * @modified By:
 */
public class MinDiffInBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3= new TreeNode(3);
        TreeNode root6 = new TreeNode(6);
        root.left = root2;
        root.right = root6;
        root2.left = root1;
        root2.right = root3;
      int result =  new MinDiffInBST().minDiffInBST(root);
        System.out.println(result);
    }
//    public int minDiffInBST(TreeNode root) {
//        int result = Integer.MAX_VALUE;
//        List<Integer> list = new ArrayList<>();
//        dfs(root,list);
//        int l = 0;
//        int r = 1;
//        while (r < list.size()){
//            result = Math.min(list.get(r)- list.get(l),result);
//            l++;
//            r++;
//        }
//        return result;
//    }
//
//    private void dfs(TreeNode root, List<Integer> list) {
//        if(root.left != null){
//            dfs(root.left,list);
//        }
//        list.add(root.val);
//        if(root.right != null){
//            dfs(root.right,list);
//        }
//    }

    int result = Integer.MAX_VALUE;
    int preVal = -1;
    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return result;
    }
    private void dfs(TreeNode root) {
        if (root == null){
            return;
        }
        if(root.left != null){
            dfs(root.left);
        }
        if (preVal == -1) {
            preVal = root.val;
        }else {
            result = Math.min(root.val - preVal, result);
            preVal = root.val;
        }

        if(root.right != null){
            dfs(root.right);
        }
    }


}
