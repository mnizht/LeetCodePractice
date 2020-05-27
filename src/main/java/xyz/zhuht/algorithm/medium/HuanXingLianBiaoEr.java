package xyz.zhuht.algorithm.medium;

import xyz.zhuht.lib.ListNode;

/**
 * zhuhaitao
 * 2020/5/26 15:03
 * 142.环形链表2
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * <p>
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * <p>
 * 说明：不允许修改给定的链表。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：tail connects to node index 1
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：head = [1,2], pos = 0
 * 输出：tail connects to node index 0
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：head = [1], pos = -1
 * 输出：no cycle
 * 解释：链表中没有环。
 * <p>
 * <p>
 *  
 * <p>
 * 进阶：
 * 你是否可以不用额外空间解决此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class HuanXingLianBiaoEr {

  private ListNode getIntersect(ListNode head) {
    ListNode tortoise = head;
    ListNode hare = head;
    while (hare != null && hare.next != null) {
      tortoise = tortoise.next;
      hare = hare.next.next;
      if (tortoise == hare) {
        return tortoise;
      }
    }
    return null;
  }

  public ListNode getDetectCycle(ListNode head) {
    if (head == null) {
      return null;
    }

    ListNode intersect = getIntersect(head);
    if (intersect == null) {
      return null;
    }

    ListNode part1 = head;
    ListNode part2 = intersect;
    while (part1 != part2) {
      part1 = part1.next;
      part2 = part2.next;
    }
    return part1;
  }
}
