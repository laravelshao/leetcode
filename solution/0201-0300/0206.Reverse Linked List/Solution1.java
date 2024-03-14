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
    /**
     * 双指针方式
     */
    public ListNode reverseList(ListNode head) {
        ListNode cur = head, pre = null;
        while (cur != null) {
            // 暂存下一个节点
            ListNode next = cur.next;
            // 修改引用指向
            cur.next = pre;
            // 暂存当前节点
            pre = cur;
            // 访问下一个节点
            cur = next;
        }

        return pre;
    }
}