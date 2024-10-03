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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        // 利用快慢双指针定位到中间元素
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 当节点数为奇数时，slow 位于中间
        // 当节点树为偶数时，slow 位于中间位置左边节点
        // 右半部分链表
        ListNode tmp = slow.next;
        // 截断链表
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);

        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (left != null && right != null) {
            if(left.val < right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        cur.next = (left == null) ? right : left;

        return dummy.next;
    }
}