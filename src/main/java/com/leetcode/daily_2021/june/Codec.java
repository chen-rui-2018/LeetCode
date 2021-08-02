package com.leetcode.daily_2021.june;

import com.leetcode.editor.model.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author： chenr
 * @date： Created on 2021/6/30 9:25
 * @version： v1.0
 * @modified By:
 */
public class Codec {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(5);
        root.left = root2;
        root.right = root3;
        root3.left = root4;
        root3.right = root5;
        Codec codec = new Codec();
        String serialize = codec.serialize(root);
        System.out.println(serialize);

        TreeNode treeNode = codec.deserialize(serialize);
        System.out.println(codec.serialize(treeNode));

    }

    /**
     * 层次遍历
     * @param root
     * @return
     */

    private String serialize(TreeNode root) {
        if(root == null){
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node != null){
                sb.append(node.val+",");
                queue.offer(node.left);
                queue.offer(node.right);
            }else {
                sb.append("null,");
            }
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("]");
        return sb.toString();
    }
    private TreeNode deserialize(String data) {
        if ("[]".equals(data)){
            return null;
        }
        String[] vals = data.substring(1,data.length()-1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (!vals[i].equals("null")) {
                node.left = new TreeNode(Integer.valueOf(vals[i]));
                queue.offer(node.left);
            }
            i++;
            if (!vals[i].equals("null")) {
                node.right = new TreeNode(Integer.valueOf(vals[i]));
                queue.offer(node.right);
            }
            i++;

        }
        return root;
    }





    /**
     * 先序遍历
     * @param root
     * @return
     */
    // Encodes a tree to a single string.
    public String serialize1(TreeNode root) {
        return rserialize(root,"");
    }

    private String rserialize(TreeNode root, String s) {
        if (root == null) {
            s += "None,";
        }else {
            s += String.valueOf(root.val)+",";
            s = rserialize(root.left,s);
            s = rserialize(root.right,s);
        }
        return s;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize1(String data) {
        String [] dataArray = data.split(",");
        List<String> dataList = new LinkedList<>(Arrays.asList(dataArray));
        return rdeserialize(dataList);
    }

    private TreeNode rdeserialize(List<String> dataList) {
        if (dataList.get(0).equals("None")){
            dataList.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(dataList.get(0)));
        dataList.remove(0);
        root.left = rdeserialize(dataList);
        root.right = rdeserialize(dataList);
        return root;
    }
}
