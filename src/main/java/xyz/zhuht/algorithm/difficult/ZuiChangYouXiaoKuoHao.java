package xyz.zhuht.algorithm.difficult;

/**
 * @author haitao zhu
 * @date 2020/7/4 9:17
 * 32.最长有效括号
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 * <p>
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ZuiChangYouXiaoKuoHao {
  public int longestValidParentheses(String s) {

    int left = 0;
    int right = 0;
    int maxLength = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        left++;
      } else {
        right++;
      }
      if (left == right) {
        maxLength = Math.max(maxLength, 2 * right);
      } else if (left < right) {
        left = right = 0;
      }
    }

    left = right = 0;
    for (int i = s.length() - 1; i >= 0; i--) {
      if (s.charAt(i) == '(') {
        left++;
      } else {
        right++;
      }
      if (left == right) {
        maxLength = Math.max(maxLength, 2 * left);
      } else if (left > right) {
        left = right = 0;
      }
    }
    return maxLength;
  }
}
