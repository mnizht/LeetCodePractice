package xyz.zhuht.lib;

/**
 * zhuhaitao
 * 2020/5/27 14:45
 */
public class ListNode {
  public int val;
  public ListNode next;

  public ListNode(int x) {
    val = x;
    next = null;
  }

  @Override
  public String toString() {
    return String.valueOf(val) + (next == null ? "" : "," + next.toString());
  }
}
