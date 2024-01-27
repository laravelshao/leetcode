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
        // 添加哑节点
        ListNode dummy = new ListNode(0, head);
        // 双指针法，需要找到倒数第N个元素
        ListNode first = dummy, second = dummy;
        // first先遍历n次
        while(n-- > 0) {
            first = first.next;
        }
        // first和second一起遍历，first遍历到最后，此时second刚好和first相差n，刚好是倒数第N个元素的前一位置
        while(first.next != null) {
            first = first.next;
            second = second.next;
        }
        // 直接将倒数第N个元素的前一位置的元素指向下下节点
        second.next = second.next.next;
        return dummy.next;
    }
}