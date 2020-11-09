package xyz.zhuht.algorithm.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author haitao zhu
 * @date 2020/11/9 15:57
 * 973. 最接近原点的 K 个点
 * 我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。
 * <p>
 * （这里，平面上两点之间的距离是欧几里德距离。）
 * <p>
 * 你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/k-closest-points-to-origin
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ZuiJieJinYuanDianDeKGeDian {
  public int[][] kClosest(int[][] points, int K) {
    Map<Integer, Integer> c = new HashMap<>(points.length);
    for (int i = 0; i < points.length; i++) {
      c.put(i, points[i][0] * points[i][0] + points[i][1] * points[i][1]);
    }
    List<Map.Entry<Integer, Integer>> list = new ArrayList<>(c.entrySet());
    list.sort(Map.Entry.comparingByValue());
    int[][] ans = new int[K][];
    for (int i = 0; i < K; i++) {
      ans[i] = points[list.get(i).getKey()];
    }
    return ans;
  }
}
