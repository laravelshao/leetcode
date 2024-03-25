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
    public boolean isBalanced(TreeNode root) {
        // 当前树的深度 = max(左子树的深度, 右子树的深度) + 1
        return recur(root) != -1;
    }

    /**
     * 返回左右子树深度小于等于1，则返回深度，否则返回-1代表不是平衡二叉树
     */
    private int recur(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = recur(root.left);
        if (left == -1) {
            return -1;
        }

        int right = recur(root.right);
        if (right == -1) {
            return -1;
        }

        // 判断左右子树的深度是否小于等于1，是则返回深度max(left, right) + 1，否则返回 -1
        return Math.abs(left - right) <= 1 ? Math.max(left, right) + 1 : -1;
    }
}