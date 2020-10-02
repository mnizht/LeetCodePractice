package xyz.zhuht.algorithm.simple;

/**
 * @author haitao zhu
 * @date 2020/10/2 16:14
 * 771.宝石与石头
 */
public class BaoShiYuShiTou {
  public int numJewelsInStones(String J, String S) {
    return (int) S.chars().filter(s -> J.indexOf(s) > -1).count();
  }

}
