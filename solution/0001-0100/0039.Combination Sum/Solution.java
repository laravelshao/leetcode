/**
 * 参考回溯算法+剪枝(回溯经典例题详解) https://leetcode.cn/problems/combination-sum/solutions/14697/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-2
 */
class Solution {
    // 结果
    private List<List<Integer>> ans = new ArrayList<>();
    // 临时路径组合
    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, 0, target);
        return ans;
    }

    /**
     * candidates 候选数组
     * index 起点下标
     * target 目标值(每减去一个元素，目标值变小)
     */
    private void dfs(int[] candidates, int index, int target) {

        // 由于进入更深层时，小于 0 的部分被剪枝，因此递归终止条件值只判断等于 0 的情况
        if (target == 0) {
            ans.add(new ArrayList(path));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            // 剪枝，前提是候选数组已经升序排列
            if (target < candidates[i]) {
                break;
            }
            path.add(candidates[i]);
            // 注意：由于每一个元素可以重复使用，下一轮搜索的起点依然是 i，这里非常容易弄错
            dfs(candidates, i, target - candidates[i]);
            // 移除最后元素状态重置
            path.remove(path.size() - 1);
        }
    }
}