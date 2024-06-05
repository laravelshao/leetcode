/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    // 前一个值，考虑边界值，用long 的最小值，防止 node.val = Integer.MIN_VALUE
    private long pre = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }
        // 二叉搜索树中旬遍历严格升序排列
        // 访问左子树
        if(!isValidBST(root.left)) {
            return false;
        }

        // 访问当前节点，当前节点小于等于前一节点，不满足
        if(root.val <= pre) {
            return false;
        }
        pre = root.val;

        // 访问右子树
        return isValidBST(root.right);
    }
}