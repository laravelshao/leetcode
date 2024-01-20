class MyLinkedList {

    ListNode head = new ListNode();
    int size = 0;

    public MyLinkedList() {

    }

    public int get(int index) {
        // index最大等于size-1
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode current = head;
        for (int i = 0; i <= index; i++) {
            current = current.next;
        }
        return current.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        // 添加到最后index最大为size，超过则非法直接返回
        if (index > size) {
            return;
        }

        // 获取index之前节点
        ListNode prev = head;
        while (index-- > 0) {
            prev = prev.next;
        }
        // 1、优先构造插入节点，新插入节点的next只想当前prev节点的next
        // 2、当前prev节点的next只想新插入节点
        prev.next = new ListNode(val, prev.next);
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }

        // 获取index之前节点
        ListNode prev = head;
        while (index-- > 0) {
            prev = prev.next;
        }

        ListNode delNode = prev.next;
        // 将前置节点next执行删除节点的next;
        prev.next = delNode.next;
        // 置空删除节点的next
        delNode.next = null;
        size--;
    }
}
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
