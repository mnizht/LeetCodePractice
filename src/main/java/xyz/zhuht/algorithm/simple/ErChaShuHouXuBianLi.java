package xyz.zhuht.algorithm.simple;

import xyz.zhuht.lib.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树后序遍历
 *
 * @author zhuht
 * @date 2021/8/22 17:01
 */
public class ErChaShuHouXuBianLi {


  public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    if (root == null) {
      return res;
    }

    Deque<TreeNode> stack = new LinkedList<>();
    TreeNode prev = null;
    while (!stack.isEmpty() || root != null) {
      while (root != null) {
        stack.push(root);
        root = root.left;
      }

      root = stack.pop();
      if (root.right == null || root.right == prev) {
        res.add(root.val);
        prev = root;
        root = null;
      } else {
        stack.push(root);
        root = root.right;
      }
    }
    return res;
  }


  public List<Integer> postorderTraversal2(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    if (root == null) {
      return res;
    }
    postorder(root, res);

    return res;
  }

  public void postorder(TreeNode node, List<Integer> res) {
    if (node != null) {
      postorder(node.left, res);
      postorder(node.right, res);
      res.add(node.val);
    }
  }

}
