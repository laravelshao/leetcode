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

    private int pre; // 前一个值

    private int res; // 结果

    public int getMinimumDifference(TreeNode root) {
        res = Integer.MAX_VALUE;
        pre = -1;
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        // 二叉搜索树的中序遍历元素值升序，最小差值存在相邻2个元素中
        if (root == null) {
            return;
        }

        dfs(root.left);
        if (pre == -1) {
            pre = root.val;
        } else {
            res = Math.min(root.val - pre, res);
            pre = root.val;
        }
        dfs(root.right);
    }
}