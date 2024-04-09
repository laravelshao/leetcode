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

    private Integer pre; //前一个值

    public boolean isValidBST(TreeNode root) {
        pre = null;
        return dfs(root);
    }

    private boolean dfs(TreeNode root) {
        // 二叉搜索树的中序遍历元素时升序排列，只需要判断后一个数字大于前一个数字就行
        if (root == null) {
            return true;
        }

        if (!dfs(root.left)) {
            return false;
        }

        if(pre == null) {
            pre = root.val;
        } else if(pre >= root.val) {
            return false;
        }
        pre = root.val;

        if (!dfs(root.right)) {
            return false;
        }

        return true;
    }
}