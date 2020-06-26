package xyz.zhuht.algorithm.simple;

import xyz.zhuht.lib.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author haitao zhu
 * @date 2020/6/26 19:53
 * 面试题02.01 移除重复节点
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 *
 * 示例1:
 *
 *  输入：[1, 2, 3, 3, 2, 1]
 *  输出：[1, 2, 3]
 * 示例2:
 *
 *  输入：[1, 1, 1, 1, 2]
 *  输出：[1, 2]
 * 提示：
 *
 * 链表长度在[0, 20000]范围内。
 * 链表元素在[0, 20000]范围内。
 * 进阶：
 *
 * 如果不得使用临时缓冲区，该怎么解决？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicate-node-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class YiChuChongFuJieDian {
  public ListNode removeDuplicateNodes(ListNode head) {
    if (head == null) {
      return head;
    }
    Set<Integer> occurred = new HashSet<Integer>();
    occurred.add(head.val);
    ListNode pos = head;
    // 枚举前驱节点
    while (pos.next != null) {
      // 当前待删除节点
      ListNode cur = pos.next;
      if (occurred.add(cur.val)) {
        pos = pos.next;
      } else {
        pos.next = pos.next.next;
      }
    }
    pos.next = null;
    return head;

  }
}
