package xyz.zhuht.algorithm.simple;


/**
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "aba"
 * 输出: True
 * 示例 2:
 * <p>
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
 * 注意:
 * <p>
 * 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class YanZhengHuiWenZiFuChuan2 {
  public static void main(String[] args) {

    System.out.println(validPalindrome("aba"));
    String str = "acbcccbcca";
    System.out.println(validPalindrome("acbcccbcca"));
  }

  public static String constructStr(String str) {
    return str + new StringBuffer(str).reverse().toString();
  }

  public static boolean validPalindrome(String s) {
    char[] chars = s.toCharArray();
    for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
      if (chars[i] != chars[j]) {
        return isPalindrome(chars, i + 1, j) || isPalindrome(chars, i, j - 1);
      }
    }
    return true;
  }

  public static boolean isPalindrome(char[] chars, int i, int j) {
    for (; i < j; i++, j--) {
      if (chars[i] != chars[j]) return false;
    }
    return true;
  }
}
