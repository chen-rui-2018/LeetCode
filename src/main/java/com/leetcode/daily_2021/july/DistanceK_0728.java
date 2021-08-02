package com.leetcode.daily_2021.july;

import com.leetcode.editor.model.TreeNode;

import java.util.*;

/**
 * @author： chenr
 * @date： Created on 2021/7/28 9:11
 * @version： v1.0
 * @modified By:
 */
public class DistanceK_0728 {
    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node7 = new TreeNode(7);
        TreeNode node4 = new TreeNode(4);
        TreeNode node0 = new TreeNode(0);
        TreeNode node8 = new TreeNode(8);

        node3.left = node5;
        node3.right = node1;
        node5.left = node6;
        node5.right = node2;
        node2.left = node7;
        node2.right = node4;
        node1.left = node0;
        node1.right = node8;

        List<Integer> list = new DistanceK_0728().distanceK(node3, node5, 0);
        for (Integer integer : list) {
            System.out.print(integer + ", ");
        }
    }

    Map<TreeNode, TreeNode> map = new HashMap<>();
    Set<TreeNode> set = new HashSet<>();
    List<Integer> res = new LinkedList<>();
    TreeNode targetNode;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        findTargetNode(root, null, target);
        dfs(targetNode, res, k);
        return res;
    }

    private void dfs(TreeNode root, List<Integer> res, int distance) {
        if (root != null && !set.contains(root)) {
            set.add(root);
            if (distance <= 0) {
                res.add(root.val);
                return;
            }
            dfs(root.left, res, distance - 1);
            dfs(root.right, res, distance - 1);
            dfs(map.get(root), res, distance - 1);
        }
    }

    private void findTargetNode(TreeNode root, TreeNode parent, TreeNode target) {
        if (null == root) {
            return;
        }
        if (root.val == target.val) {
            targetNode = root;
        }
        map.put(root, parent);
        findTargetNode(root.left, root, target);
        findTargetNode(root.right, root, target);
    }

}
