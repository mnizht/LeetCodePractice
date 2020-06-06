package xyz.zhuht.algorithm;

import org.junit.Test;
import xyz.zhuht.algorithm.difficult.ZhuZhuangTuZhongZuiDaDeJuXing;
import xyz.zhuht.algorithm.difficult.ZuiChangLianXuXuLie;

/**
 * zhuhaitao
 * 2020/5/30 15:13
 */
public class DifficultTest {

  /**
   * 128.最长连续序列
   */
  @Test
  public void ZuiChangLianXuXuLie() {
    int[] nums = new int[]{100, 4, 200, 1, 3, 2};
    ZuiChangLianXuXuLie test = new ZuiChangLianXuXuLie();
    System.out.println(test.longestConsecutive(nums));

  }

  /**
   * 84.柱状图中最大的矩形
   */
  @Test
  public void ZhuZhuangTuZhongZuiDaDeJuXingTest() {
    int[] heights = new int[]{2, 1, 5, 6, 2, 3};
    ZhuZhuangTuZhongZuiDaDeJuXing test = new ZhuZhuangTuZhongZuiDaDeJuXing();
    int area = test.largestRectangleArea(heights);
    System.out.println(area);
  }
}
