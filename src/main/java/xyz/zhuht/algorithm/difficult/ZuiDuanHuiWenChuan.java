package xyz.zhuht.algorithm.difficult;

import java.util.Arrays;

/**
 * @author haitao zhu
 * @date 2020/8/29 10:17
 * 214.最短回文串
 * 给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "aacecaaa"
 * 输出: "aaacecaaa"
 * 示例 2:
 * <p>
 * 输入: "abcd"
 * 输出: "dcbabcd"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ZuiDuanHuiWenChuan {
  public String shortestPalindrome(String s) {
    int n = s.length();
    int[] fail = new int[n];
    Arrays.fill(fail, -1);
    for (int i = 1; i < n; ++i) {
      int j = fail[i - 1];
      while (j != -1 && s.charAt(j + 1) != s.charAt(i)) {
        j = fail[j];
      }
      if (s.charAt(j + 1) == s.charAt(i)) {
        fail[i] = j + 1;
      }
    }
    int best = -1;
    for (int i = n - 1; i >= 0; --i) {
      while (best != -1 && s.charAt(best + 1) != s.charAt(i)) {
        best = fail[best];
      }
      if (s.charAt(best + 1) == s.charAt(i)) {
        ++best;
      }
    }
    String add = (best == n - 1 ? "" : s.substring(best + 1));
    StringBuffer ans = new StringBuffer(add).reverse();
    ans.append(s);
    return ans.toString();
  }
}


