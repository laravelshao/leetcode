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

    public List<List<Integer>> levelOrder(TreeNode root) {
        // 层序遍历的原理是利用一个辅助的队列，根节点先入队
        // 然后遍历队列中所有节点出队，将它们存放到一个临时列表中；再将其左右子节点入队，用于后续层级遍历
        // 将临时数组存储到答案数组中。
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {
            // 临时存放层元素的列表
            List<Integer> tmp = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                tmp.add(node.val);

                // 将当前元素的左右子节点添加到队列中，用于下一层的遍历
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