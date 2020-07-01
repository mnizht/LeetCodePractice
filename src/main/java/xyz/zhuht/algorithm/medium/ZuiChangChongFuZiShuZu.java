package xyz.zhuht.algorithm.medium;

/**
 * @author haitao zhu
 * @date 2020/7/1 9:37
 * 718. 最长重复子数组
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出: 3
 * 解释:
 * 长度最长的公共子数组是 [3, 2, 1]。
 * 说明:
 * <p>
 * 1 <= len(A), len(B) <= 1000
 * 0 <= A[i], B[i] < 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ZuiChangChongFuZiShuZu {
  public int findLength(int[] A, int[] B) {
    int a_len = A.length;
    int b_len = B.length;
    int ans = 0;
    int dp[][] = new int[a_len + 1][b_len + 1];
    for (int i = a_len - 1; i >= 0; i--) {
      for (int j = b_len - 1; j >= 0; j--) {
        dp[i][j] = A[i] == B[j] ? dp[i + 1][j + 1] + 1 : 0;
        ans = Math.max(ans, dp[i][j]);
      }
    }
    return ans;
  }
}
