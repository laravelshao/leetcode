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

        // 统计节点数
        ListNode cur = head;
        int count = 1; // cur 就是第一个节点
        while (cur.next != null) {
            count++;
            cur = cur.next;
        }

        k %= count;
        // 如果 k % count 等于 0 就是原始状态
        if (k == 0) {
            return head;
        }

        ListNode fast = head, slow = head;
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