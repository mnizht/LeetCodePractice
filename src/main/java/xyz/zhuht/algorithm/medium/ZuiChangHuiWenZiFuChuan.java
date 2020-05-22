package xyz.zhuht.algorithm.medium;

/**
 * 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ZuiChangHuiWenZiFuChuan {

  public static void main(String[] args) {
    String string1 = "babad";
    String string2 = "cbbd";
    String string3 = "a";
    String string4 = "ac";
    String string5 = "";
    String string6 = "aaaa";


    System.out.println(longestPalindrome(string1));


  }

  public static String longestPalindrome(String s) {
    int n = s.length();
    boolean[][] dp = new boolean[n][n];
    String ans = "";
    for (int j = 0; j < n; j++) {
      for (int i = 0; i <= j; i++) {
        boolean temp = s.charAt(i) == s.charAt(j);
        if (i == j) {
          dp[i][j] = true;
        } else if (j - i == 1) {
          dp[i][j] = temp;
        } else if (i + 1 == j - 1) {
          dp[i][j] = temp;
        } else {
          dp[i][j] = dp[i + 1][j - 1] && temp;
        }
        if (dp[i][j] && j - i >= ans.length()) {
          ans = s.substring(i, j + 1);
        }
      }
    }
    print(dp, s);
    return ans;
  }

  public static void print(boolean[][] dp, String s) {
    for (int i = 0; i < s.length() - 1; i++) {
      for (int j = i; j < s.length(); j++) {
        System.out.print(String.format("(%d,%d)", i, j) + dp[i][j] + ";");
      }
      System.out.println();
    }
  }
}
