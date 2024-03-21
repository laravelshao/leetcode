/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // 锯齿形层序遍历的原理是利用一个辅助的双端队列，根节点先入队
        // 然后遍历队列中所有节点出队，将它们存放到一个临时双端列表中，需要根据奇数行还是偶数行来决定方向。
        // res.size 之前添加的行列表数，当前行为 res.size + 1，通过 (res.size + 1) % 2 来判断：
        // 1.如果是奇数行，从左到右，添加到行列表的尾部
        // 2.如果是偶数行，从右到左，添加到行列表的头部
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {
            LinkedList<Integer> tmp = new LinkedList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                // res.size 之前添加的行列表数，当前行为 res.size + 1
                if ((res.size() + 1) % 2 == 1) {
                    // 奇数行：正序遍历，添加尾部
                    tmp.addLast(node.val);
                } else {
                    // 偶数行：逆序遍历，添加头部
                    tmp.addFirst(node.val);
                }

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(tmp);
        }

        return res;
    }
}