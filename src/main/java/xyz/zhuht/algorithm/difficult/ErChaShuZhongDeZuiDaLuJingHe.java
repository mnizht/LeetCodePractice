package xyz.zhuht.algorithm.difficult;

import xyz.zhuht.lib.TreeNode;

/**
 * @author haitao zhu
 * @date 2020/6/21 21:04
 * 124.二叉树中的最大路径和
 * 给定一个非空二叉树，返回其最大路径和。
 * <p>
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * <p>
 * 1
 * / \
 * 2   3
 * <p>
 * 输出: 6
 * 示例 2:
 * <p>
 * 输入: [-10,9,20,null,null,15,7]
 * <p>
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * <p>
 * 输出: 42
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ErChaShuZhongDeZuiDaLuJingHe {
  int maxSum = Integer.MIN_VALUE;

  public int maxPathSum(TreeNode root) {
    maxGain(root);
    return maxSum;
  }

  public int maxGain(TreeNode node) {
    if (node == null) {
      return 0;
    }

    // 递归计算左右子节点的最大贡献值
    // 只有在最大贡献值大于 0 时，才会选取对应子节点
    int leftGain = Math.max(maxGain(node.left), 0);
    int rightGain = Math.max(maxGain(node.right), 0);

    // 节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
    int priceNewpath = node.val + leftGain + rightGain;

    // 更新答案
    maxSum = Math.max(maxSum, priceNewpath);

    // 返回节点的最大贡献值
    return node.val + Math.max(leftGain, rightGain);
  }
}
