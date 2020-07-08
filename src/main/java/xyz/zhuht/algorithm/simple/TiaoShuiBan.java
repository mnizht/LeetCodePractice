package xyz.zhuht.algorithm.simple;

/**
 * @author haitao zhu
 * @date 2020/7/8 14:26
 * 面试题16.11 跳水板
 * <p>
 * 你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter，长度较长的木板长度为longer。你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。
 * <p>
 * 返回的长度需要从小到大排列。
 * <p>
 * 示例：
 * <p>
 * 输入：
 * shorter = 1
 * longer = 2
 * k = 3
 * 输出： {3,4,5,6}
 * 提示：
 * <p>
 * 0 < shorter <= longer
 * 0 <= k <= 100000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diving-board-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TiaoShuiBan {
  public int[] divingBoard(int shorter, int longer, int k) {
    if (k == 0) {
      return new int[0];
    }
    if (shorter == longer) {
      return new int[]{shorter * k};
    }
    int[] lens = new int[k + 1];
    for (int i = 0; i <= k; i++) {
      lens[i] = shorter * (k - i) + longer * i;
    }
    return lens;
  }
}
