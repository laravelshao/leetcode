class Solution {

    private Map<String, TreeNode> treeNodeMap = new HashMap<>();

    private Set<String> keySet = new HashSet<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {

        visitTreeNode(root);

        return new ArrayList(treeNodeMap.values());
    }

    private String visitTreeNode(TreeNode node) {
        if (node == null) {
            return "";
        }

        String treeNodeKey = node.val + "(" + visitTreeNode(node.left) + "," + visitTreeNode(node.right) + ")";
        if (!keySet.add(treeNodeKey)) {
            treeNodeMap.put(treeNodeKey, node);
        }

        return treeNodeKey;
    }
}
