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
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int levelCount;
        // 二叉树层序遍历
        while (!queue.isEmpty()) {
            // 每层元素个数
            levelCount = queue.size();
            for (int i = 0; i < levelCount; i++) {
                // 出队元素
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (i == levelCount - 1) {
                    res.add(node.val);
                }
            }
        }

        return res;
    }
}