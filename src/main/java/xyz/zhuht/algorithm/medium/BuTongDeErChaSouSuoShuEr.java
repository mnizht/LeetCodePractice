package xyz.zhuht.algorithm.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * @author haitao zhu
 * @date 2020/7/21 7:16
 * 95.不同的二叉搜索树二
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：3
 * 输出：
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * 解释：
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 8
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BuTongDeErChaSouSuoShuEr {
  public List<TreeNode> generateTrees(int n) {
    if (n == 0) {
      return new LinkedList<>();
    }
    return generateTree(1, n);
  }

  public List<TreeNode> generateTree(int start, int end) {
    List<TreeNode> list = new LinkedList<>();
    if (start > end) {
      list.add(null);
      return list;
    }
    for (int i = start; i <= end; i++) {
      List<TreeNode> leftTrees = generateTree(start, i - 1);
      List<TreeNode> rightTrees = generateTree(i + 1, end);

      for (TreeNode left : leftTrees) {
        for (TreeNode right : rightTrees) {
          TreeNode currNode = new TreeNode(i);
          currNode.left = left;
          currNode.right = right;
          list.add(currNode);
        }
      }
    }
    return list;
  }
}
