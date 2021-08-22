package xyz.zhuht.algorithm.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 102。二叉树的层序遍历
 *
 * @author zhuht
 * @date 2021/8/22 17:18
 */
public class ErChaShuDeCengXuBianLi {

  public List<List<Integer>> levelOrder(TreeNode root) {

    List<List<Integer>> res = new ArrayList<>();
    if (root == null) {
      return res;
    }
    int floor = 0;
    traversal(root, res, floor);
    return res;

  }

  public void traversal(TreeNode node, List<List<Integer>> res, int floor) {
    if (node != null) {
      List<Integer> integers;
      if (res.size() > floor) {
        integers = res.get(floor);
      } else {
        integers = new ArrayList<>();
        res.add(integers);
      }
      integers.add(node.val);
      floor++;
      traversal(node.left, res, floor);
      traversal(node.right, res, floor);
    }
  }
}
