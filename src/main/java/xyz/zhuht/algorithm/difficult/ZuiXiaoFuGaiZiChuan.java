package xyz.zhuht.algorithm.difficult;

import java.util.HashMap;
import java.util.Map;

/**
 * zhuhaitao
 * 2020/5/23 14:36
 * 76.最小覆盖子串
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。
 * <p>
 * 示例：
 * <p>
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 * <p>
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ZuiXiaoFuGaiZiChuan {
  public static void main(String[] args) {

    String s = "cabwefgewcwaefgcf";
    String t = "cae";
    System.out.println(minWindow(s, t));
  }

  public static Map<Character, Integer> tCharMap = new HashMap<>();
  public static Map<Character, Integer> tempCharMap = new HashMap<>();

  public static String minWindow(String s, String t) {
    if (s.length() < t.length()) return "";
    int tLen = t.length();
    for (int i = 0; i < tLen; i++) {
      char c = t.charAt(i);
      tCharMap.put(c, tCharMap.getOrDefault(c, 0) + 1);
    }

    int start = 0;
    int end = Integer.MAX_VALUE;
    int left = 0;
    int right = 0;
    while (right < s.length()) {
      Character rc = s.charAt(right);
      if (tCharMap.containsKey(rc)) {
        tempCharMap.put(rc, tempCharMap.getOrDefault(rc, 0) + 1);
      }
      while (check()) {
        if (right - left + 1 < end - start) {
          start = left;
          end = right + 1;
        }

        Character lc = s.charAt(left);
        if (tempCharMap.containsKey(lc)) {
          tempCharMap.put(lc, tempCharMap.getOrDefault(lc, 0) - 1);
        }
        left++;
      }
      right++;
    }

    return end == Integer.MAX_VALUE ? "" : s.substring(start, end);

  }

  public static boolean check() {
    for (Map.Entry<Character, Integer> next : tCharMap.entrySet()) {
      if (tempCharMap.getOrDefault(next.getKey(), 0) < next.getValue()) {
        return false;
      }
    }
    return true;
  }
}
