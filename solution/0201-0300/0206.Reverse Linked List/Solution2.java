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
     * 递归方式
     */
    public ListNode reverseList(ListNode head) {
        return recur(head, null);
    }

    private ListNode recur(ListNode cur, ListNode pre) {
        if (cur == null) {
            return pre;
        }

        // 递归后继节点
        ListNode res = recur(cur.next, cur);
        // 修改节点引用前驱节点 pre
        cur.next = pre;
        // 返回反转链表的头节点
        return res;
    }
}