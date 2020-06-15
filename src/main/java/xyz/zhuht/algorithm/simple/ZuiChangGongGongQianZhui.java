package xyz.zhuht.algorithm.simple;

/**
 * @author haitao zhu
 * @date 2020/6/15 10:36
 * 14.最长公共前缀
 * <p>
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ZuiChangGongGongQianZhui {

  public String longestCommonPrefix(String[] strs) {
    if (strs.length == 0 || strs[0].length() == 0) {
      return "";
    }
    char curr = strs[0].charAt(0);
    StringBuilder result = new StringBuilder();
    int i = 0;
    boolean go = true;
    while (go) {
      for (String str : strs) {

        if (str.length() <= i || curr != str.charAt(i)) {
          go = false;
          break;
        }
      }
      if (go) {
        result.append(curr);
        i++;
        if (strs[0].length() <= i) {
          return result.toString();
        }
        curr = strs[0].charAt(i);
      }

    }
    return result.toString();
  }
}
