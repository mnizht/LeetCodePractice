package xyz.zhuht.algorithm.medium;

/**
 * @author haitao zhu
 * @date 2020/7/15 13:13
 * 96.不同的二叉搜索树
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BuTongDeErChaSouSuoShu {
  public int numTrees(int n) {
    long c = 1;
    for (int i = 0; i < n; i++) {
      c = c * 2 * (2 * i + 1) / (i + 2);
    }
    return (int) c;
  }
}
