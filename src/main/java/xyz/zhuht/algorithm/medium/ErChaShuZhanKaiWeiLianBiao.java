package xyz.zhuht.algorithm.medium;

/**
 * @author haitao zhu
 * @date 2020/8/2 15:54
 * 114.二叉树展开为链表
 * <p>
 * 给定一个二叉树，原地将它展开为一个单链表。
 * <p>
 *  
 * <p>
 * 例如，给定二叉树
 * <p>
 * 1
 * / \
 * 2   5
 * / \   \
 * 3   4   6
 * 将其展开为：
 * <p>
 * 1
 * \
 * 2
 * \
 * 3
 * \
 * 4
 * \
 * 5
 * \
 * 6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ErChaShuZhanKaiWeiLianBiao {
  public void flatten(TreeNode root) {
    TreeNode curr = root;
    while (curr != null) {
      if (curr.left != null) {
        TreeNode next = curr.left;
        TreeNode predecessor = next;
        while (predecessor.right != null) {
          predecessor = predecessor.right;
        }
        predecessor.right = curr.right;
        curr.left = null;
        curr.right = next;
      }
      curr = curr.right;
    }
  }
}
