package xyz.zhuht.algorithm.simple;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1.两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class LiangShuZhiHe {
  public static void main(String[] args) {

    int[] input = {123,2048,4096,6144,8192};
//    int[] input = {2048,4096,6144,1,2,-5,-3};

    int target = 8192;
    System.out.println(Arrays.toString(twoSum(input, target)));
    System.out.println(Arrays.toString(twoSum2(input, target)));
  }

  public static int[] twoSum(int[] nums, int target) {
    int volume =2048; //100000000000
    int bitMode = volume-1;//011111111111
    int [] result =new int[volume];

    for (int i=0;i<nums.length;i++){
      int c = (target - nums[i]) & bitMode;
      if (result[c]!=0){
        return new int[]{result[c]-1,i};
      }
      result[nums[i] & bitMode]=i+1;
    }
    return null;
  }

  public static int[] twoSum2(int[] nums,int target){
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      if (map.containsKey(complement)) {
        return new int[] { map.get(complement), i };
      }
      map.put(nums[i], i);
    }
    throw new IllegalArgumentException("No two sum solution");
  }

}


