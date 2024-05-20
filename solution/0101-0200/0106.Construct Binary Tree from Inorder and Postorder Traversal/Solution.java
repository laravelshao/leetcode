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
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        return recur(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode recur(int[] inorder, int inLeft, int inRight, int[] postorder, int postLeft, int postRight) {
        // 终止条件
        if (inLeft > inRight || postLeft > postRight) {
            return null;
        }

        // 构造根节点
        int rootVal = postorder[postRight];
        TreeNode root = new TreeNode(rootVal);
        // 计算中旬遍历的分界线索引
        int pivotIdx = inLeft;
        while (inorder[pivotIdx] != rootVal) {
            pivotIdx++;
        }

        // 递归构造左右子树
        root.left = recur(inorder, inLeft, pivotIdx - 1, postorder, postLeft, postLeft + pivotIdx - inLeft - 1);
        root.right = recur(inorder, pivotIdx + 1, inRight, postorder, postLeft + pivotIdx - inLeft, postRight - 1);

        return root;
    }
}