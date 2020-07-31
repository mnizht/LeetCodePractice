package xyz.zhuht.algorithm.simple;

/**
 * @author haitao zhu
 * @date 2020/7/31 9:16
 * 面试题08.03 魔术索引
 * 魔术索引。 在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i。给定一个有序整数数组，编写一种方法找出魔术索引，若有的话，在数组A中找出一个魔术索引，如果没有，则返回-1。若有多个魔术索引，返回索引值最小的一个。
 * <p>
 * 示例1:
 * <p>
 * 输入：nums = [0, 2, 3, 4, 5]
 * 输出：0
 * 说明: 0下标的元素为0
 * 示例2:
 * <p>
 * 输入：nums = [1, 1, 1]
 * 输出：1
 * 提示:
 * <p>
 * nums长度在[1, 1000000]之间
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/magic-index-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MoShuSuoYin {
  public int findMagicIndex(int[] nums) {

    int i = 0;
    while (i < nums.length) {
      if (nums[i] == i) {
        return i;
      } else if (nums[i] > i) {
        i = nums[i];
      } else {
        i++;
      }
    }
    return -1;
  }
}
