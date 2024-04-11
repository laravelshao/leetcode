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
    public ListNode rotateRight(ListNode head, int k) {
        // 小于2个节点
        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = head;
        // 统计节点数
        int count = 0;
        for (; cur != null; cur = cur.next) {
            count++;
        }

        // 如果 k % count 等于 0 就是原始状态
        k %= count;
        if (k == 0) {
            return head;
        }

        ListNode slow = head, fast = head;
        // 快指针先走 k 步
        while (k-- > 0) {
            fast = fast.next;
        }

        // 快慢指针一起走
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        ListNode ans = slow.next;
        slow.next = null;
        fast.next = head;
        return ans;
    }
}