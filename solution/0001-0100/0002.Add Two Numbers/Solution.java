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

        ListNode ans = new ListNode();
        ListNode cur = ans;
        // 进位值
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            // 当前位置总和
            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
            // 进位值等于 sum/10
            carry = sum / 10;
            // 当前位置值 sum%10
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }

        return ans.next;
    }
}