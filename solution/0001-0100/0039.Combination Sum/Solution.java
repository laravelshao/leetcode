/**
 * 参考回溯算法+剪枝(回溯经典例题详解) https://leetcode.cn/problems/combination-sum/solutions/14697/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-2
 */
class Solution {

    private List<List<Integer>> ans = new ArrayList<>();

    private List<Integer> group = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 升序排列
        Arrays.sort(candidates);

        dfs(candidates, target, 0);

        return ans;
    }

    private void dfs(int[] candidates, int target, int start) {
        if (target == 0) {
            ans.add(new ArrayList<>(group));
            return;
        }

        // 剪枝2：从 start 开始遍历，避免生成重复子集
        for (int i = start; i < candidates.length; i++) {
            // 剪枝1：如果当前遍历元素大于剩余目标值，直接结束，因为原始数组排序后，后面元素更大
            if (target - candidates[i] < 0) {
                break;
            }

            group.add(candidates[i]);
            dfs(candidates, target - candidates[i], i);
            // 回退
            group.remove(group.size() - 1);
        }
    }
}