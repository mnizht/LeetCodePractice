package xyz.zhuht.algorithm.simple;

/**
 * @author haitao zhu
 * @date 2020/8/3 22:17
 * 415.字符串相加
 * <p>
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 * <p>
 *  
 * <p>
 * 提示：
 * <p>
 * num1 和num2 的长度都小于 5100
 * num1 和num2 都只包含数字 0-9
 * num1 和num2 都不包含任何前导零
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ZiFuChuanXiangJia {
  public String addStrings(String num1, String num2) {
    int i = num1.length() - 1;
    int j = num2.length() - 1;
    int carry = 0;
    StringBuilder ans = new StringBuilder();
    while (i >= 0 || j >= 0 || carry > 0) {
      int a = i >= 0 ? num1.charAt(i--) - '0' : 0;
      int b = j >= 0 ? num2.charAt(j--) - '0' : 0;
      int curr = carry + a + b;
      carry = curr / 10;
      ans.append(curr % 10);
    }
    ans.reverse();
    return ans.toString();
  }
}
