package tencent;

import tencent.model.TreeNode;

import javax.sound.midi.Soundbank;

/**
 * @author： chenr
 * @date： Created on 2021/1/26 10:16
 * @version： v1.0
 * @modified By:
 */
public class LowestCommonAncestor {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        TreeNode root2 = new TreeNode(2);
        TreeNode root8 = new TreeNode(8);
        TreeNode root0 = new TreeNode(0);
        TreeNode root4 = new TreeNode(4);
        TreeNode root7 = new TreeNode(7);
        TreeNode root9 = new TreeNode(9);
        TreeNode root3 = new TreeNode(3);
        TreeNode root5 = new TreeNode(5);
        root.left = root2;
        root.right = root8;
        root2.left = root0;
        root2.right = root4;
        root8.left = root7;
        root8.right = root9;
        root4.left = root3;
        root4.right = root5;
        TreeNode node = new LowestCommonAncestor().lowestCommonAncestor(root, root3, root5);
        System.out.println(node.val);
    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode treeNode = root;
        while (true) {
            if (p.val < treeNode.val && q.val < treeNode.val && treeNode.left != null) {
                treeNode = treeNode.left;
            } else if (p.val > treeNode.val && q.val > treeNode.val && treeNode.right != null) {
                treeNode = treeNode.right;
            } else {
                break;
            }
        }
        return treeNode;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int val = (p.val- root.val) * (q.val-root.val);
        if (val <= 0) {
            return root;
        }
        if (p.val < root.val && q.val < root.val && root.left != null) {
            root = lowestCommonAncestor(root.left, p, q);
        }
        if (p.val > root.val && q.val > root.val && root.right != null) {
            root = lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val>p.val && root.val>q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if(root.val<p.val && root.val<q.val) {
            return lowestCommonAncestor(root.right,p,q);
        }
        return root;


    }
}
