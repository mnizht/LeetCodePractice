package xyz.zhuht.algorithm.medium;

/**
 * 乘积最大子数组
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 * <p>
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ChengJiZuiDaZiShuZu {
  public static void main(String[] args) {
    int[] a = {2, 3, -2, 4};
    int[] b = {-2, 0, -1};
    System.out.println(maxProduct(a));
    System.out.println(maxProduct(b));
  }

  public static int maxProduct(int[] nums) {
    int max = Integer.MIN_VALUE;
    int maxTemp = 1;
    int minTemp = 1;

    for (Integer num : nums) {
      // 乘到负数时，会导致最大变最小。最小变最大
      if (num < 0) {
        maxTemp ^= minTemp;
        minTemp ^= maxTemp;
        maxTemp ^= minTemp;
      }
      maxTemp = Math.max(maxTemp * num, num);
      minTemp = Math.min(minTemp * num, num);

      max = Math.max(max, maxTemp);

    }
    return max;
  }
}
