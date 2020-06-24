package xyz.zhuht.algorithm.medium;

import java.util.Arrays;

/**
 * @author haitao zhu
 * @date 2020/6/24 10:50
 * 16.最接近的三数之和
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *  
 * <p>
 * 提示：
 * <p>
 * 3 <= nums.length <= 10^3
 * -10^3 <= nums[i] <= 10^3
 * -10^4 <= target <= 10^4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ZuiJieJinDeSanShuZhiHe {
  public int threeSumClosest(int[] nums, int target) {
    // 预设值，考虑到nums中元素最大为1000，三个数的和也不会超过10000；
    // 使用Integer.MAX_VALUE 的话下面的计算会溢出
    int result = 10000;
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 2; i++) {
      int x = nums[i];
      int l = i + 1;
      int r = nums.length - 1;
      while (l < r) {
        int sum = x + nums[l] + nums[r];
        if (sum == target) return sum;
        if (Math.abs(sum - target) < Math.abs(result - target)) {
          result = sum;
        }
        if (sum > target) {
          r--;
        }
        if (sum < target) {
          l++;
        }
      }
    }

    return result;
  }
}
