package com.leetcode.editor.title_daily;

import com.leetcode.editor.model.TreeNode;

/**
 * @author： chenr
 * @date： Created on 2020/9/30 10:14
 * @version： v1.0
 * @modified By:
 */
public class InsertIntoBST_20200930 {
    public static void main(String[] args) {
        TreeNode n4 = new TreeNode(4);
        TreeNode n2 = new TreeNode(2);
        TreeNode n1 = new TreeNode(1);
        TreeNode n3 = new TreeNode(3);
        TreeNode n7 = new TreeNode(7);
        n4.left = n2;
        n4.right = n7;
        n2.left = n1;
        n2.right = n3;
        TreeNode treeNode =   new InsertIntoBST_20200930().insertIntoBST(n4,8);
        System.out.println(treeNode.val);

    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }
        if (root.val > val  ) {
            if(root.left != null) {
                insertIntoBST(root.left, val);
            }else {
                root.left = new TreeNode(val);
            }
        }
        if (root.val < val  ) {
            if(root.right != null) {
                insertIntoBST(root.right, val);
            }else {
                root.right = new TreeNode(val);
            }
        }
        return root;
    }
    public TreeNode insertIntoBST2(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }
        TreeNode pre = root;
        while(pre != null) {
            if (pre.val > val) {
                if (pre.left != null) {
                    pre = pre.left;
                }else {
                    pre.left = new TreeNode(val);
                    break;
                }

            }else {
                if (pre.right != null) {
                    pre = pre.right;
                }else {
                    pre.right = new TreeNode(val);
                    break;
                }

            }

        }
        return root;
    }

}
