class Solution {

    private List<List<Integer>> res = new ArrayList<>();

    private List<Integer> group = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(n, k, 1);
        return res;
    }

    private void dfs(int n, int k, int start) {
        // 判断是否为解
        if (group.size() == k) {
            // 记录解
            res.add(new ArrayList<>(group));
            return;
        }

        // 剪枝：
        for (int i = start; i <= n; i++) {
            // 做出选择
            group.add(i);
            // 递归调用
            dfs(n, k, i + 1);
            // 回退选择
            group.remove(group.size() - 1);
        }
    }
}