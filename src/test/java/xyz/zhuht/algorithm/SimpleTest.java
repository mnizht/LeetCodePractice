package xyz.zhuht.algorithm;

import org.junit.Test;
import xyz.zhuht.algorithm.simple.ErJinZhiQiuHe;
import xyz.zhuht.algorithm.simple.YanZhengHuiWenChuan;

/**
 * @author haitao zhu
 * @date 2020/6/19 23:00
 */
public class SimpleTest {

  @Test
  public void ErJinZhiQiuHeTest() {
    ErJinZhiQiuHe test = new ErJinZhiQiuHe();
    String a = "11";
    String b = "1";
    System.out.println(test.addBinary(a, b));
  }

  @Test
  public void YanZhengHuiWenChuanTest() {
    YanZhengHuiWenChuan test = new YanZhengHuiWenChuan();
    String str1 = "A man, a plan, a canal: Panama";
    String str2 = "race a car";
    String str3 = "";
    String str4 = " ";
    String str5 = ",";
    String str6 = "a";

    System.out.println(test.isPalindrome(str1));
    System.out.println(test.isPalindrome(str2));
    System.out.println(test.isPalindrome(str3));
    System.out.println(test.isPalindrome(str4));
    System.out.println(test.isPalindrome(str5));
    System.out.println(test.isPalindrome(str6));

  }
}
