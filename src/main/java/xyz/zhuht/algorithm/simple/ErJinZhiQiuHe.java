package xyz.zhuht.algorithm.simple;

/**
 * @author haitao zhu
 * @date 2020/6/23 9:31
 * 67.二进制求和
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * <p>
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 * <p>
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *  
 * <p>
 * 提示：
 * <p>
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-binary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ErJinZhiQiuHe {
  public String addBinary(String a, String b) {

    int len = Math.max(a.length(), b.length());

    a = addO(a, len - a.length());
    b = addO(b, len - b.length());
    int jin_wei = 0;
    int cur_wei = 0;
    StringBuilder res = new StringBuilder();
    len -= 1;
    while (len >= 0) {
      char aa = a.charAt(len);
      char bb = b.charAt(len);

      cur_wei = aa + bb - '0' - '0' + jin_wei;
      res.insert(0, (cur_wei % 2));
      jin_wei = cur_wei / 2;
      len--;

    }
    if (jin_wei > 0) {
      res.insert(0, 1);
    }
    return res.toString();
  }

  private String addO(String s, int len) {
    StringBuilder sb = new StringBuilder(s);
    while (len-- > 0) {
      sb.insert(0, '0');
    }
    return sb.toString();
  }
}
