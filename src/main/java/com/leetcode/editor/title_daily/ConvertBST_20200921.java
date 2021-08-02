package com.leetcode.editor.title_daily;

import com.leetcode.editor.model.TreeNode;
import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;
import sun.rmi.runtime.NewThreadAction;

import java.util.ArrayList;
import java.util.List;

/**
 * @author： chenr
 * @date： Created on 2020/9/21 16:58
 * @version： v1.0
 * @modified By:
 */
public class ConvertBST_20200921 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left =  new TreeNode(2);
        treeNode.right = new TreeNode(13);

//        new ConvertBST_20200921().convertBST1(treeNode);
        new ConvertBST_20200921().convertBST(treeNode);
        System.out.println(treeNode.val+","+treeNode.left.val+","+treeNode.right.val);
    }
    List<Integer> list = new ArrayList<>();
    public TreeNode convertBST1(TreeNode root) {
        dfs(root);
        iterator(root);
        return  root;
    }

    private void iterator(TreeNode root) {
        if(root != null ) {
            int value = root.val;
            for (Integer integer : list) {
                if (integer > value) {
                    root.val += integer;
                }
            }
            iterator(root.left);
            iterator(root.right);
        }
    }


    private void dfs(TreeNode root) {
        if(root != null) {
            list.add(root.val);
            dfs(root.left);
            dfs(root.right);
        }
    }

    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }


}
