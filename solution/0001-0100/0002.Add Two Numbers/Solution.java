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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        // 进位值
        int carry = 0;
        ListNode current = result;
        while (l1 != null || l2 != null || carry != 0) {
            // 当前位置总和
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            // 进位值等于 sum/10
            carry = sum / 10;
            // 当前位置值 sum%10
            current.next = new ListNode(sum % 10);
            current = current.next;
            l1 = (l1 == null) ? null : l1.next;
            l2 = (l2 == null) ? null : l2.next;
        }

        return result.next;
    }
}