package xyz.zhuht.algorithm.simple;

/**
 * @author haitao zhu
 * @date 2020/8/14 22:33
 * 20.有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class YouXiaoDeKuoHao {
  public boolean isValid(String s) {
    int length = s.length();
    if ((length & 1) == 1) {
      return false;
    }
    char[] chars = new char[length + 1];
    chars[0] = ' ';
    int index = 1;
    char[] chars1 = s.toCharArray();
    for (Character c : chars1) {
      switch (c) {
        case ')':
          if (chars[--index] != '(') {
            return false;
          }
          break;
        case ']':
          if (chars[--index] != '[') {
            return false;
          }
          break;
        case '}':
          if (chars[--index] != '{') {
            return false;
          }
          break;
        default:
          chars[index++] = c;
      }
    }
    return index == 1;

  }
}
