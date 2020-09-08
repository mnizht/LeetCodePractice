package xyz.zhuht.algorithm.simple;

/**
 * @author haitao zhu
 * @date 2020/8/30 14:42
 * 557.反转字符串中的单词三
 * <p>
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入："Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 *  
 * <p>
 * 提示：
 * <p>
 * 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FanZhuanZiFuChuanZhongDeDanCiSan {
  public String reverseWords(String s) {
    String[] s1 = s.split(" ");
    char[] chars = s.toCharArray();
    StringBuilder ans = new StringBuilder();
    boolean preIsBlank = true;
    int index = 0;
    for (char c : chars) {
      if (c == ' ') {
        ans.append(" ");
      }
      if (c != ' ' && preIsBlank) {
        ans.append(new StringBuilder(s1[index++].trim()).reverse());
      }

      preIsBlank = c == ' ';
    }
    return ans.toString();
  }
}
