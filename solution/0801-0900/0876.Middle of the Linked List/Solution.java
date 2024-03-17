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
    public ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;
        // 设置2个指针，fast：每次走2步，slow：每次走1步
        // 两种情况：
        // 1、链表节点数为奇数时，当fast指针到尾节点，slow刚好到中间
        // 2、链表节点数为偶数时，当fast指针指向尾节点之后的null时，slow刚好在中间的第二个节点
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}