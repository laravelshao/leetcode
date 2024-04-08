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

    // Map<Val, idx>
    private Map<Integer, Integer> inOrderMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // 中序遍历：左子节点->根节点->右子节点
        // 后序遍历：左子节点->右子节点->根节点，后序遍历的最后一个节点为数的根节点

        // 参考题解：https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/solutions/50561/tu-jie-gou-zao-er-cha-shu-wei-wan-dai-xu-by-user72
        for (int i = 0; i < inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }

        return dfs(postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode dfs(int[] postorder, int inLeft, int inRight, int postLeft, int postRight) {
        if (inLeft > inRight || postLeft > postRight) {
            return null;
        }

        int rootVal = postorder[postRight];
        int rootIdx = inOrderMap.get(rootVal);
        TreeNode node = new TreeNode(rootVal);

        // 构造左右子树
        node.left = dfs(postorder, inLeft, rootIdx - 1, postLeft, postLeft + rootIdx - inLeft - 1);
        node.right = dfs(postorder, rootIdx + 1, inRight, postLeft + rootIdx - inLeft, postRight - 1);

        return node;
    }
}