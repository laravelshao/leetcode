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

    int ans, k;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root) {
        // 二拆搜索树满足条件：左子节点 < 根节点 < 右子节点
        // 中旬遍历：先遍历左子节点，再遍历根节点，后遍历右子节点
        if (root == null) {
            return;
        }

        dfs(root.left);
        if (--k == 0) {
            ans = root.val;
            return;
        }

        dfs(root.right);
    }
}