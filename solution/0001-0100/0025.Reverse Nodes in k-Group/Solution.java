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
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;
        while (true) {
            ListNode tail = pre;
            // 判断剩余元素是否满足k个
            for(int i = 0; i < k; i++) {
                tail = tail.next;
                if(tail == null) {
                    return dummy.next;
                }
            }

            // 每组头插法翻转k个节点，只需要遍历k-1次
            ListNode cur = pre.next, next;
            for(int i = 0; i < k - 1; i++) {
                next = cur.next;
                cur.next = next.next;
                next.next = pre.next;
                pre.next = next;
            }

            pre = cur;
        }
    }
}