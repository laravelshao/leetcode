/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        // 1. root 左右子节点都能找到最近公共祖先，左右子节点在 root 两侧，则最近公共祖先就是 root
        // 2. root 左右子节点只有一个可以找到最近公共祖先，说明都在同侧子树，返回不为空最近公共祖先
        // 3. 都没找到 返回 null
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null && right == null) {
            return null;
        }
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        return root; // if (left != null && right != null)
    }
}