/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA, B = headB;
        while (A != B) {
            // 假设A链表节点数为a，B链表节点数为b，公共尾部节点数为c
            // 先遍历A链表再遍历B链表到相交节点时，步数为 a + b - c
            // 先遍历B链表再遍历A链表到相交节点时，步数为 b + a - c
            // 如果有相交，A、B都指向相交节点；否则都指向null
            A = A != null ? A.next : headB;
            B = B != null ? B.next : headA;
        }

        return A;
    }
}