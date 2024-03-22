/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {

    Node pre, head;

    public Node treeToDoublyList(Node root) {
        if(root == null) {
            return null;
        }

        dfs(root);

        // 将前后节点进行指向，pre此时为tail
        head.left = pre;
        pre.right = head;
        return head;
    }

    private void dfs(Node cur) {
        // 中序遍历
        if(cur == null) {
            return;
        }
        // 遍历左子树
        dfs(cur.left);
        if(pre != null) {
            pre.right = cur;
        } else {
            // pre 为空则当前节点为 head
            head = cur;
        }
        cur.left = pre;
        pre = cur;
        // 遍历右子树
        dfs(cur.right);
    }
}