package xyz.zhuht.algorithm;

import org.junit.Test;
import xyz.zhuht.algorithm.medium.LRUHuanCunJiZhi;

/**
 * zhuhaitao
 * 2020/5/25 10:48
 * 算法-中级 测试
 */

public class MediumTest {

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
}
