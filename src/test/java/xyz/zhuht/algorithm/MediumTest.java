package xyz.zhuht.algorithm;

import org.junit.Test;
import xyz.zhuht.algorithm.medium.DanCiChaiFen;
import xyz.zhuht.algorithm.medium.DiZengZiXuLie;
import xyz.zhuht.algorithm.medium.HeKeBeiKZhengChuDeZiShuZu;
import xyz.zhuht.algorithm.medium.LRUHuanCunJiZhi;
import xyz.zhuht.algorithm.medium.MeiRiWenDu;
import xyz.zhuht.algorithm.medium.SanJiaoXingZuiXiaoLuJingHe;
import xyz.zhuht.algorithm.medium.XunZhaoChongFuShu;
import xyz.zhuht.algorithm.medium.ZhengShuChaiFen;
import xyz.zhuht.algorithm.medium.ZiFuChuanJieMa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * zhuhaitao
 * 2020/5/25 10:48
 * 算法-中级 测试
 */

public class MediumTest {

  /**
   * 491.递增子序列
   */
  @Test
  public void DiZengZiXuLieTest() {
    DiZengZiXuLie test = new DiZengZiXuLie();
    int[] nums = {3, 9, -9, 5, -2, 0};
    List<List<Integer>> subsequences = test.findSubsequences(nums);
    System.out.println(subsequences.toString());
  }


  /**
   * 343.整数拆分
   */
  @Test
  public void ZhengShuChaiFenTest() {
    ZhengShuChaiFen test = new ZhengShuChaiFen();
    int i = test.integerBreak(10);
    System.out.printf("ans = " + i);
  }

  /**
   * 120.三角形最小路径和
   */
  @Test
  public void sanJiaoXingZuiXiaoLuJingHeTest() {
    SanJiaoXingZuiXiaoLuJingHe test = new SanJiaoXingZuiXiaoLuJingHe();
    List<List<Integer>> triangle = new ArrayList<>();
    triangle.add(Arrays.asList(2));
    triangle.add(Arrays.asList(3, 4));
    triangle.add(Arrays.asList(6, 5, 7));
    triangle.add(Arrays.asList(4, 1, 8, 3));
    int ans = test.minimumTotal(triangle);
    System.out.println(ans);
  }

  /**
   * 139.单词拆分
   */
  @Test
  public void DanCiChaiFenTest() {
    DanCiChaiFen test = new DanCiChaiFen();
    String s = "leetcode";
    List<String> wordDict = Arrays.asList("leet", "code");

    System.out.println(test.wordBreak(s, wordDict));
  }

  /**
   * 739. 每日温度
   */
  @Test
  public void MeiRiWenDu() {
    MeiRiWenDu test = new MeiRiWenDu();
    int[] T = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
    int[] result = test.dailyTemperatures(T);
    System.out.println(Arrays.toString(result));
  }

  /**
   * 394.字符串解码
   */
  @Test
  public void ZiFuChuanJieMa() {
    ZiFuChuanJieMa test = new ZiFuChuanJieMa();
    String s = "3[a]2[bc]";
    String s2 = "3[a2[c]]";
    String s3 = "2[abc]3[cd]ef";
    System.out.println(test.decodeString(s));
    System.out.println(test.decodeString(s2));
    System.out.println(test.decodeString(s3));
  }

  /**
   * 974.和可被K整除的子数组
   */
  @Test
  public void HeKeBeiKZhengChuDeZiShuZuTest() {
    HeKeBeiKZhengChuDeZiShuZu test = new HeKeBeiKZhengChuDeZiShuZu();
    int[] A = new int[]{4, 5, 0, -2, -3, 1};
    int K = 5;
    System.out.println(test.subarraysDivByK(A, K));
    System.out.println(test.subarraysDivByK2(A, K));
  }

  /**
   * 146.LRU缓存机制
   */
  @Test
  public void LRUHuanCunJiZhiTest() {
    LRUHuanCunJiZhi cache = new LRUHuanCunJiZhi(2);
    cache.put(1, 1);
    cache.put(2, 2);
    cache.get(1);       // 返回  1
    cache.put(3, 3);    // 该操作会使得密钥 2 作废
    cache.get(2);       // 返回 -1 (未找到)
    cache.put(4, 4);    // 该操作会使得密钥 1 作废
    cache.get(1);       // 返回 -1 (未找到)
    cache.get(3);       // 返回  3
    cache.get(4);       // 返回  4

  }

  /**
   * 287.寻找重复数
   */
  @Test
  public void XunZhaoChongFuShuTest() {
    XunZhaoChongFuShu test = new XunZhaoChongFuShu();
    int[] nnums = new int[]{1, 3, 4, 2, 2};
    System.out.println(test.findDuplicate(nnums));

  }
}
