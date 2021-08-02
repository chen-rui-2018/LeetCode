package tencent.model;

/**
 * @author： chenr
 * @date： Created on 2021/1/26 10:13
 * @version： v1.0
 * @modified By:
 */
public class TreeNode {
  public  int val;
  public  TreeNode left;
  public  TreeNode right;
  public  TreeNode() {}
  public  TreeNode(int val) { this.val = val; }
  public  TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
