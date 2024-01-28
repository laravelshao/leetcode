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
    public ListNode swapPairs(ListNode head) {
        // 递归的终止条件是后续没有元素或只有一个元素
        if(head == null || head.next == null) {
            return head;
        }

        // 新头节点为head下一个节点
        ListNode newHead = head.next;
        // head变为第二节点后，其下一个节点是新节点的下一节点 
        head.next = swapPairs(newHead.next);
        // 新头节点的下一个节点为原头结点
        newHead.next = head;
        return newHead;
    }
}