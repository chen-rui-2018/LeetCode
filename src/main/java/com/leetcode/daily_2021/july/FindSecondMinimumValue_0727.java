package com.leetcode.daily_2021.july;

import com.leetcode.editor.model.TreeNode;

/**
 * nJdxyA+ms8lg
 * @author： chenr
 * @date： Created on 2021/7/27 9:27
 * @version： v1.0
 * @modified By: %ZQzadsQ
 */
public class FindSecondMinimumValue_0727 {
    public static void main(String[] args) {
        TreeNode root =new TreeNode(2);
        TreeNode root2 =new TreeNode(2);
        TreeNode root5 =new TreeNode(5);
        TreeNode root52 =new TreeNode(5);
        TreeNode root57 =new TreeNode(7);
        root.left = root2;
        root.right = root5;
        root5.right = root57;
        root5.left = root52;
        int secondMinimumValue = new FindSecondMinimumValue_0727().findSecondMinimumValue(root);
        System.out.println(secondMinimumValue);

    }
    int res;
    int rootVal;
    public int findSecondMinimumValue(TreeNode root) {
        res = -1;
        rootVal = root.val;
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null){
            return;
        }
        if (res != -1 && root.val >= res) {
            return;
        }
        if(root.val > rootVal){
            res = root.val;
        }
        dfs(root.left);
        dfs(root.right);
    }
}
