package xyz.zhuht.algorithm.difficult;

/**
 * zhuhaitao
 * 2020/5/30 11:45
 * 84.柱状图中最大的矩形
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * <p>
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * <p>
 *  
 * <p>
 * <p>
 * <p>
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 * <p>
 *  
 * <p>
 * <p>
 * <p>
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ZhuZhuangTuZhongZuiDaDeJuXing {
  int[] h;

  public int largestRectangleArea(int[] heights) {
    h = heights;
    int count = -1;
    int max = 0;
    while (++count < heights.length) {
      max = Math.max(max, heights[count] * getWeight(count));
    }
    return max;
  }

  public int getWeight(int count) {
    int height = h[count];
    int left = count;
    while (left > -1 && h[left] >= height) {
      left--;
    }
    int right = count;
    while (right < h.length && h[right] >= height) {
      right++;
    }
    return right - left - 1;
  }
}
