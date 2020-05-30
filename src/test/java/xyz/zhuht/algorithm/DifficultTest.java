package xyz.zhuht.algorithm;

import org.junit.Test;
import xyz.zhuht.algorithm.difficult.ZhuZhuangTuZhongZuiDaDeJuXing;

/**
 * zhuhaitao
 * 2020/5/30 15:13
 */
public class DifficultTest {

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
