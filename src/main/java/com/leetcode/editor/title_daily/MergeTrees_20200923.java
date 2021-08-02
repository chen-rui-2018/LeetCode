package com.leetcode.editor.title_daily;

import com.leetcode.editor.model.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.lang.management.MemoryManagerMXBean;

/**
 * @author： chenr
 * @date： Created on 2020/9/23 15:00
 * @version： v1.0
 * @modified By:
 */
public class MergeTrees_20200923 {
    public static void main(String[] args) {

        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(5);
        TreeNode roota = new TreeNode(5);
        TreeNode rootb = new TreeNode(3);
        TreeNode rootc = new TreeNode(6);
        TreeNode rootd = new TreeNode(2);
        TreeNode roote = new TreeNode(1);
        TreeNode rootf = new TreeNode(4);


        root1.left = root2;
        root1.right = root3;
        root2.left = root4;
        root2.right = root5;

        roota.left = rootb;
        roota.right = rootc;
        rootb.left = rootd;
        rootc.left = roote;
        roote.right = rootf;

        TreeNode  treeNode=  new MergeTrees_20200923().mergeTrees(root1,roota);
        System.out.println(treeNode.val);
    }
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if(t2 == null){
            return t1;
        }
        TreeNode merge = new TreeNode(t1.val+t2.val);
        merge.right =  mergeTrees(t1.right, t2.right);
        merge.left =  mergeTrees(t1.left , t2.left);
        return merge;
    }
}
