package xyz.zhuht.algorithm.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * zhuhaitao
 * 2020/5/27 16:16
 * 974.和可被K整除的子数组
 * 给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：A = [4,5,0,-2,-3,1], K = 5
 * 输出：7
 * 解释：
 * 有 7 个子数组满足其元素之和可被 K = 5 整除：
 * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 *  
 * <p>
 * 提示：
 * <p>
 * 1. 1 <= A.length <= 30000
 * 2. -10000 <= A[i] <= 10000
 * 3. 2 <= K <= 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subarray-sums-divisible-by-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class HeKeBeiKZhengChuDeZiShuZu {
  public int subarraysDivByK(int[] A, int K) {
    Map<Integer, Integer> mod = new HashMap<>();
    mod.put(0, 1);
    int sum = 0;
    for (int num : A) {
      sum += num;
      int modulus = Math.floorMod(sum, K);
      mod.put(modulus, mod.getOrDefault(modulus, 0) + 1);
    }

    int count = 0;
    for (Map.Entry<Integer, Integer> entry : mod.entrySet()) {
      count += entry.getValue() * (entry.getValue() - 1) / 2;
    }
    return count;
  }

  public int subarraysDivByK2(int[] A, int K){
    int[] mod = new int[K];
    mod[0] = 1;
    int count = 0;
    int sum = 0;
    for (int num: A){
      sum += num;
      int modulus = Math.floorMod(sum,K);
      count += mod[modulus];
      ++mod[modulus];
    }
    return count;

  }
}
