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
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        // 参考题解：https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solutions/8946/qian-xu-bian-li-python-dai-ma-java-dai-ma-by-liwei/?envType=study-plan-v2&envId=selected-coding-interview
        return recur(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode recur(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
        // 递归终止条件
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }

        // 前序遍历：根节点、左子树节点，右子树节点
        // 中旬遍历：左子树节点，根节点，右子树节点

        // 构造根节点
        int rootVal = preorder[preLeft];
        TreeNode root = new TreeNode(rootVal);
        // 中序遍历根据根节点值划分左右子树区间(前提节点值无重复元素)
        int pivotIndex = inLeft;
        while (inorder[pivotIndex] != rootVal) {
            pivotIndex++;
        }

        // 递归左右子树构造
        root.left = recur(preorder, preLeft + 1, preLeft + pivotIndex - inLeft, inorder, inLeft, pivotIndex - 1);
        root.right = recur(preorder, preLeft + pivotIndex - inLeft + 1, preRight, inorder, pivotIndex + 1, inRight);

        return root;
    }
}