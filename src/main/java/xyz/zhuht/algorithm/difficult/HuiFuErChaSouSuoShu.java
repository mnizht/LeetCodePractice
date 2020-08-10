package xyz.zhuht.algorithm.difficult;

import xyz.zhuht.lib.TreeNode;

/**
 * @author haitao zhu
 * @date 2020/8/8 22:46
 * 99.恢复二叉搜索树
 * 二叉搜索树中的两个节点被错误地交换。
 * <p>
 * 请在不改变其结构的情况下，恢复这棵树。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,null,null,2]
 * <p>
 *    1
 *   /
 *  3
 *   \
 *    2
 * <p>
 * 输出: [3,1,null,null,2]
 * <p>
 *    3
 *   /
 *  1
 *   \
 *    2
 * 示例 2:
 * <p>
 * 输入: [3,1,4,null,null,2]
 * <p>
 * 3
 * / \
 * 1   4
 *    /
 *   2
 * <p>
 * 输出: [2,1,4,null,null,3]
 * <p>
 * 2
 * / \
 * 1   4
 *    /
 *  3
 * 进阶:
 * <p>
 * 使用 O(n) 空间复杂度的解法很容易实现。
 * 你能想出一个只使用常数空间的解决方案吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/recover-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class HuiFuErChaSouSuoShu {
  public void recoverTree(TreeNode root) {
    TreeNode x = null, y = null, pred = null, predecessor = null;

    while (root != null) {
      if (root.left != null) {
        // predecessor 节点就是当前 root 节点向左走一步，然后一直向右走至无法走为止
        predecessor = root.left;
        while (predecessor.right != null && predecessor.right != root) {
          predecessor = predecessor.right;
        }

        // 让 predecessor 的右指针指向root，继续遍历左子树
        if (predecessor.right == null) {
          predecessor.right = root;
          root = root.left;
        }
        // 说明左子树已经访问完了，我么需要断开链接
        else {
          if (pred != null && root.val < pred.val) {
            y = root;
            if (x == null) {
              x = pred;
            }
          }
          pred = root;

          predecessor.right = null;
          root = root.right;
        }
      }
      // 如果没有左孩子，则直接访问右孩子
      else {
        if (pred != null && root.val < pred.val) {
          y = root;
          if (x == null) {
            x = pred;
          }
        }
        pred = root;
        root = root.right;
      }
    }
    swap(x, y);
  }

  public void swap(TreeNode x, TreeNode y) {
    int tem = x.val;
    x.val = y.val;
    y.val = tem;
  }
}
