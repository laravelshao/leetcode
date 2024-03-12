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

    private List<List<Integer>> ans = new ArrayList<>();

    // 存储路径
    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        dfs(root, targetSum);
        return ans;
    }

    private void dfs(TreeNode node, int targetSum) {
        if (node == null) {
            return;
        }

        // 前序遍历，先添加节点值
        path.add(node.val);
        // 目标值减去当前节点值
        targetSum = targetSum - node.val;

        // 满足条件 目标值为0 且 左右子树都为null(叶子节点)
        if (targetSum == 0 && node.left == null && node.right == null) {
            ans.add(new ArrayList<>(path));
        }
        dfs(node.left, targetSum);
        dfs(node.right, targetSum);

        // 回退
        path.remove(path.size() - 1);
    }
}