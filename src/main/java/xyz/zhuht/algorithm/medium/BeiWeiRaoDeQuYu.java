package xyz.zhuht.algorithm.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author haitao zhu
 * @date 2020/8/11 23:17
 * 130.被围绕的区域
 * <p>
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 * <p>
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * <p>
 * 示例:
 * <p>
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 运行你的函数后，矩阵变为：
 * <p>
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 解释:
 * <p>
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/surrounded-regions
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BeiWeiRaoDeQuYu {

  int[] dx = {1, -1, 0, 0};
  int[] dy = {0, 0, 1, -1};

  public void solve(char[][] board) {
    int n = board.length;
    if (n == 0) {
      return;
    }
    int m = board[0].length;
    Queue<int[]> queue = new LinkedList<int[]>();
    for (int i = 0; i < n; i++) {
      if (board[i][0] == 'O') {
        queue.offer(new int[]{i, 0});
      }
      if (board[i][m - 1] == 'O') {
        queue.offer(new int[]{i, m - 1});
      }
    }
    for (int i = 1; i < m - 1; i++) {
      if (board[0][i] == 'O') {
        queue.offer(new int[]{0, i});
      }
      if (board[n - 1][i] == 'O') {
        queue.offer(new int[]{n - 1, i});
      }
    }
    while (!queue.isEmpty()) {
      int[] cell = queue.poll();
      int x = cell[0], y = cell[1];
      board[x][y] = 'A';
      for (int i = 0; i < 4; i++) {
        int mx = x + dx[i], my = y + dy[i];
        if (mx < 0 || my < 0 || mx >= n || my >= m || board[mx][my] != 'O') {
          continue;
        }
        queue.offer(new int[]{mx, my});
      }
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (board[i][j] == 'A') {
          board[i][j] = 'O';
        } else if (board[i][j] == 'O') {
          board[i][j] = 'X';
        }
      }
    }
  }
}

