/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        while (true) {
            ListNode last = prev;
            // 判断剩余元素是否满足k个
            for (int i = 0; i < k; i++) {
                last = last.next;
                if (last == null) {
                    return dummy.next;
                }
            }

            // 翻转k个节点
            ListNode current = prev.next, next;
            for (int i = 0; i < k - 1; i++) {
                next = current.next;
                current.next = next.next;
                next.next = prev.next;
                prev.next = next;
            }

            prev = current;
        }
    }
}