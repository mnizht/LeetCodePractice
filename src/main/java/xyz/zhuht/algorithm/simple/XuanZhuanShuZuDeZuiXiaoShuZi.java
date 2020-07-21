package xyz.zhuht.algorithm.simple;

/**
 * @author haitao zhu
 * @date 2020/7/22 7:27
 * 剑指offer11.旋转数组的最小数字
 * <p>
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[3,4,5,1,2]
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：[2,2,2,0,1]
 * 输出：0
 * 注意：本题与主站 154 题相同：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class XuanZhuanShuZuDeZuiXiaoShuZi {
  public int minArray(int[] numbers) {

    int left = 0;
    int right = numbers.length - 1;
    while (left < right) {
      int med = left + (right - left) / 2;
      if (numbers[med] < numbers[right]) {
        right = med;
      } else if (numbers[med] > numbers[right]) {
        left = med + 1;
      } else {
        right--;
      }
    }
    return numbers[left];
  }
}
