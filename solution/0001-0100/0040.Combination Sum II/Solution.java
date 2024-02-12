class Solution {

    // 结果
    private List<List<Integer>> ans = new ArrayList<>();
    // 组合
    private List<Integer> combination  = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        // 排序是剪枝的关键
        Arrays.sort(candidates);
        dfs(candidates, 0, target);
        return ans;
    }

    private void dfs(int[] candidates, int index, int target){
        // 满足条件则添加到结果中
        if(target == 0) {
            ans.add(new ArrayList(combination));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            // 大剪枝：减去 candidates[i] 小于 0，因为已经升序排列，减去后面的 candidates[i + 1]、candidates[i + 2] 肯定也小于 0，因此用 break 结束循环
            if(candidates[index] > target) {
                break;
            }

            // 小剪枝：同一层相同数值的结点，从第 2 个开始，候选数更少，结果一定发生重复，因此跳过，用 continue
            if(i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }

            combination.add(candidates[i]);
            // 因为候选集合中的元素只能使用一次，所以往下查询时索引从i+1开始
            dfs(candidates, i + 1, target - candidates[i]);
            // 移除组合中最后元素
            combination.remove(combination.size() - 1);
        }
    }
}