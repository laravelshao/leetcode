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
    public ListNode partition(ListNode head, int x) {
        // 新建2个链表来承载俩部分数据
        ListNode smallDummy = new ListNode(), bigDummy = new ListNode();
        ListNode smallCur = smallDummy, bigCur = bigDummy;
        while (head != null) {
            if (head.val < x) {
                smallCur.next = head;
                smallCur = smallCur.next;
            } else {
                bigCur.next = head;
                bigCur = bigCur.next;
            }
            // 指向后继节点
            head = head.next;
        }

        // 拼接2个链表：small 指针指向较大值链表的虚节点下一个
        smallCur.next = bigDummy.next;
        // 需要置为空，链表尾结点的next置空
        // 因为原始链表中大于x的值不是最后一个元素时，bigCur所在位置后面还存在值，可能会导致环状结构
        bigCur.next = null;

        return smallDummy.next;
    }
}