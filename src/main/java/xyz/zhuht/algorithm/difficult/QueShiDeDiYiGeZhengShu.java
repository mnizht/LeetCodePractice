package xyz.zhuht.algorithm.difficult;

/**
 * @author haitao zhu
 * @date 2020/6/27 10:59
 * 41.缺失的第一个正数
 * 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,0]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 示例 3:
 * <p>
 * 输入: [7,8,9,11,12]
 * 输出: 1
 *  
 * <p>
 * 提示：
 * <p>
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-missing-positive
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class QueShiDeDiYiGeZhengShu {
  public int firstMissingPositive(int[] nums) {
    int n = nums.length;
    for (int i = 0; i < n; ++i) {
      while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
        int temp = nums[nums[i] - 1];
        nums[nums[i] - 1] = nums[i];
        nums[i] = temp;
      }
    }
    for (int i = 0; i < n; ++i) {
      if (nums[i] != i + 1) {
        return i + 1;
      }
    }
    return n + 1;

  }
}
