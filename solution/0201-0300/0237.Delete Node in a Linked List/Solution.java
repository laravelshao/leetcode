/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        // 因为访问不到头节点，可以考虑将node的下一个节点值往前复制
        node.val = node.next.val;
        node.next = node.next.next;
    }
}