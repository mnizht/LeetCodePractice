package xyz.zhuht.algorithm.difficult;

import xyz.zhuht.lib.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author haitao zhu
 * @date 2020/6/18 21:38
 * 1028.从先序遍历还原二叉树
 */
public class CongXianXuBianLiHuanYuanErChaShu {
  public TreeNode recoverFromPreorder(String S) {
    Deque<TreeNode> path = new LinkedList<TreeNode>();
    int pos = 0;
    while (pos < S.length()) {
      int level = 0;
      while (S.charAt(pos) == '-') {
        ++level;
        ++pos;
      }
      int value = 0;
      while (pos < S.length() && Character.isDigit(S.charAt(pos))) {
        value = value * 10 + (S.charAt(pos) - '0');
        ++pos;
      }
      TreeNode node = new TreeNode(value);
      if (level == path.size()) {
        if (!path.isEmpty()) {
          path.peek().left = node;
        }
      } else {
        while (level != path.size()) {
          path.pop();
        }
        path.peek().right = node;
      }
      path.push(node);
    }
    while (path.size() > 1) {
      path.pop();
    }
    return path.peek();

  }
}
