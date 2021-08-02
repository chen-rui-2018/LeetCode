package com.leetcode.daily_2021.july;

import com.leetcode.editor.model.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author： chenr
 * @date： Created on 2021/8/1 22:15
 * @version： v1.0
 * @modified By:
 */
public class D0731_verticalTraversal {
    public static void main(String[] args) {

    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<int[]> nodes = new ArrayList<>();
        dfs(root, 0, 0, nodes);
        Collections.sort(nodes, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            } else if (o1[1] != o2[1]) {
                return o1[1] - o2[1];
            } else {
                return o1[2] - o2[2];
            }
        });
        List<List<Integer>> list = new ArrayList<>();
        int size = 0;
        int lastcol = Integer.MIN_VALUE;
        for (int[] node : nodes) {
            int col = node[0], row = node[1], value = node[2];
            if (col != lastcol ){
                lastcol =col;
                list.add(new ArrayList<>());
                size++;
            }
            list.get(size-1).add(value);
        }
        return list;
    }

    private void dfs(TreeNode node, int row, int col, List<int[]> nodes) {
        if (node == null) {
            return;
        }
        nodes.add(new int[]{col, row, node.val});
        dfs(node.left, row + 1, col - 1, nodes);
        dfs(node.right, row + 1, col + 1, nodes);
    }
}
