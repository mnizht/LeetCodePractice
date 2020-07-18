package xyz.zhuht.algorithm.simple;

/**
 * @author haitao zhu
 * @date 2020/7/17 14:34
 * 35.搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 * <p>
 * 输入: [1,3,5,6], 0
 * 输出: 0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SouSuoChaRuWeiZhi {
  public int searchInsert(int[] nums, int target) {
    if (nums.length == 0) {
      return 0;
    }
    int left = 0;
    int right = nums.length - 1;

    int ans = nums.length;
    while (left < right) {

      int mid = (right - left) / 2 + left;
      System.out.println(String.format("left= %d, right= %d, mid= %d", left, right, mid));
      if (nums[mid] == target) {
        return mid;
      }
      if (nums[mid] < target) {
        left = mid + 1;
      }
      if (nums[mid] > target) {
        ans = mid;
        right = mid - 1;
      }
    }
    return ans;
  }

}
