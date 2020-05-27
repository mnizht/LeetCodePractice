package xyz.zhuht.algorithm;

import org.junit.Test;
import xyz.zhuht.algorithm.medium.HeKeBeiKZhengChuDeZiShuZu;
import xyz.zhuht.algorithm.medium.LRUHuanCunJiZhi;
import xyz.zhuht.algorithm.medium.XunZhaoChongFuShu;

/**
 * zhuhaitao
 * 2020/5/25 10:48
 * 算法-中级 测试
 */

public class MediumTest {

  /**
   * 974.和可被K整除的子数组
   */
  @Test
  public void HeKeBeiKZhengChuDeZiShuZuTest() {
    HeKeBeiKZhengChuDeZiShuZu test = new HeKeBeiKZhengChuDeZiShuZu();
    int[] A = new int[]{4,5,0,-2,-3,1};
    int K = 5;
    System.out.println(test.subarraysDivByK(A,K));
    System.out.println(test.subarraysDivByK2(A,K));
  }

  /**
   * 146.LRU缓存机制
   */
  @Test
  public void LRUHuanCunJiZhiTest() {
    LRUHuanCunJiZhi cache = new LRUHuanCunJiZhi(2);
    cache.put(1, 1);
    cache.put(2, 2);
    cache.get(1);       // 返回  1
    cache.put(3, 3);    // 该操作会使得密钥 2 作废
    cache.get(2);       // 返回 -1 (未找到)
    cache.put(4, 4);    // 该操作会使得密钥 1 作废
    cache.get(1);       // 返回 -1 (未找到)
    cache.get(3);       // 返回  3
    cache.get(4);       // 返回  4

  }

  /**
   * 287.寻找重复数
   */
  @Test
  public void XunZhaoChongFuShuTest() {
    XunZhaoChongFuShu test = new XunZhaoChongFuShu();
    int[] nnums = new int[]{1, 3, 4, 2, 2};
    System.out.println(test.findDuplicate(nnums));

  }
}
