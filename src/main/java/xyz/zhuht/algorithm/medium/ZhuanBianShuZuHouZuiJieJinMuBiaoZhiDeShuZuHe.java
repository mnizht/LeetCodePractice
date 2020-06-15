package xyz.zhuht.algorithm.medium;

import java.util.Arrays;

/**
 * @author haitao zhu
 * @date 2020/6/14 14:30
 * 1300.转变数组后最接近目标值的数组和
 */
public class ZhuanBianShuZuHouZuiJieJinMuBiaoZhiDeShuZuHe {
  public int findBestValue(int[] arr, int target) {
    int mean = target / arr.length;
    Arrays.sort(arr);

    int i = 0;
    for (; i < arr.length; i++)
      if (arr[i] <= mean)
        target -= arr[i];
      else break;

    int trend = Integer.MAX_VALUE;
    for (int j = mean; j <= arr[arr.length - 1]; j++) {
      int tmp = Math.abs(target - j * (arr.length - i));
      if (tmp >= trend)
        return j - 1;
      else
        trend = tmp;

      if (j == arr[i])
        target -= arr[i++];
    }
    return arr[arr.length - 1];
  }
}
