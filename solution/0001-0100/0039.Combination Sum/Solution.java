class Solution {
    // 结果
    private List<List<Integer>> ans = new ArrayList<>();
    // 临时组合
    private List<Integer> tmpCombine = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, 0, target);
        return ans;
    }

    private void dfs(int[] candidates, int index, int target) {
        if (target == 0) {
            ans.add(new ArrayList(tmpCombine));
            return;
        }

        if (index >= candidates.length || candidates[index] > target) {
            return;
        }

        dfs(candidates, index + 1, target);
        tmpCombine.add(candidates[index]);
        dfs(candidates, index, target - candidates[index]);
        tmpCombine.remove(tmpCombine.size() - 1);
    }
}