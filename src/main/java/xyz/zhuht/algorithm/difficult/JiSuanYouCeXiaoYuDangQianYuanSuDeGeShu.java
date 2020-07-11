package xyz.zhuht.algorithm.difficult;

import java.util.ArrayList;
import java.util.List;

/**
 * @author haitao zhu
 * @date 2020/7/11 9:06
 * 315.计算右侧小于当前元素的个数
 * 给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
 * <p>
 * 示例:
 * <p>
 * 输入: [5,2,6,1]
 * 输出: [2,1,1,0]
 * 解释:
 * 5 的右侧有 2 个更小的元素 (2 和 1).
 * 2 的右侧仅有 1 个更小的元素 (1).
 * 6 的右侧有 1 个更小的元素 (1).
 * 1 的右侧有 0 个更小的元素.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class JiSuanYouCeXiaoYuDangQianYuanSuDeGeShu {
  public List<Integer> countSmaller(int[] nums) {
    List<Integer> ans = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      int count = 0;
      for (int j = i; j < nums.length; j++) {
        if (nums[j] < nums[i]) {
          count++;
        }
      }
      ans.add(count);
    }
    return ans;
  }
}
