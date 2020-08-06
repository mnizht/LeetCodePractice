package xyz.zhuht.lib;

/**
 * @author haitao zhu
 * @date 2020/5/31 9:26
 */
public class TreeNode {
  public int val;
  public TreeNode left;
  public TreeNode right;

  public TreeNode() {
  }

  public TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }

  public TreeNode(int x) {
    val = x;
  }
}
