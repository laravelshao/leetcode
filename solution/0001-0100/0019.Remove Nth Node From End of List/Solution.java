/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(0, head);
        // 双指针法，需要找到倒数第 n 个元素
        ListNode slow = dummy, fast = dummy;
        // 快指针先遍历 n 次
        while (n-- > 0) {
            fast = fast.next;
        }

        // 快慢指针一起走，当快指针到最后时，慢指针刚好到倒数第 n 个节点的前面，快慢指针相差 n
        // 快慢指针一起遍历，快指针遍历到最后，此时慢指针刚好和快指针相差 n，刚好是倒数第 n 个元素的前一位置
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // 直接将倒数第 n 个元素的前一位置的元素指向下下节点
        slow.next = slow.next.next;

        return dummy.next;
    }
}