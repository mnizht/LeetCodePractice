package xyz.zhuht.algorithm.difficult;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author haitao zhu
 * @date 2020/7/26 23:04
 * 329.矩阵中的最长递增路径
 * <p>
 * 给定一个整数矩阵，找出最长递增路径的长度。
 * <p>
 * 对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums =
 * [
 * [9,9,4],
 * [6,6,8],
 * [2,1,1]
 * ]
 * 输出: 4
 * 解释: 最长递增路径为 [1, 2, 6, 9]。
 * 示例 2:
 * <p>
 * 输入: nums =
 * [
 * [3,4,5],
 * [3,2,6],
 * [2,2,1]
 * ]
 * 输出: 4
 * 解释: 最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class JuZhenZhongDeZuiChangDiZengLuJing {

  public int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
  public int rows, columns;

  public int longestIncreasingPath(int[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return 0;
    }
    rows = matrix.length;
    columns = matrix[0].length;
    int[][] outdegrees = new int[rows][columns];
    for (int i = 0; i < rows; ++i) {
      for (int j = 0; j < columns; ++j) {
        for (int[] dir : dirs) {
          int newRow = i + dir[0], newColumn = j + dir[1];
          if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns && matrix[newRow][newColumn] > matrix[i][j]) {
            ++outdegrees[i][j];
          }
        }
      }
    }
    Queue<int[]> queue = new LinkedList<int[]>();
    for (int i = 0; i < rows; ++i) {
      for (int j = 0; j < columns; ++j) {
        if (outdegrees[i][j] == 0) {
          queue.offer(new int[]{i, j});
        }
      }
    }
    int ans = 0;
    while (!queue.isEmpty()) {
      ++ans;
      int size = queue.size();
      for (int i = 0; i < size; ++i) {
        int[] cell = queue.poll();
        int row = cell[0], column = cell[1];
        for (int[] dir : dirs) {
          int newRow = row + dir[0], newColumn = column + dir[1];
          if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns && matrix[newRow][newColumn] < matrix[row][column]) {
            --outdegrees[newRow][newColumn];
            if (outdegrees[newRow][newColumn] == 0) {
              queue.offer(new int[]{newRow, newColumn});
            }
          }
        }
      }
    }
    return ans;
  }


}
