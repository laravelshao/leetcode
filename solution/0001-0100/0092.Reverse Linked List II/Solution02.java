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

    private ListNode successor;

    /**
     * 递归方法实现：https://leetcode.cn/problems/reverse-linked-list-ii/solutions/37247/bu-bu-chai-jie-ru-he-di-gui-di-fan-zhuan-lian-biao/?envType=study-plan-v2&envId=top-interview-150
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // base case：left 等于 1，就是反转前 right 个节点
        if(left == 1) {
            return reverseN(head, right);
        }

        // 前进到反转的起点触发反转前 N 个节点逻辑
        head.next = reverseBetween(head.next, left - 1, right - 1);

        return head; 
    }

    /**
     * 反转以 head 开始的 n 个节点，返回反转后的头节点
     */
    private ListNode reverseN(ListNode head, int n) {
        if(n == 1) {
            successor = head.next;
            return head;
        }

        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        // 将反转后的 head 节点指向后面的节点
        head.next = successor;

        return last;
    }
}