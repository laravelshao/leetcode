class Solution {

    // 结果列表
    private List<List<Integer>> ans = new ArrayList<>();
    // 临时组合
    private List<Integer> group = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return ans;
        }

        boolean[] selected = new boolean[nums.length];
        dfs(nums, selected);
        return ans;
    }

    private void dfs(int[] nums, boolean[] selected) {
        // 终止条件：状态条件等于元素个数
        if(group.size() == nums.length) {
            ans.add(new ArrayList<>(group));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            // 剪枝：已选择过的
            if(!selected[i]) {
                // 未选择过
                selected[i] = true; // 标记选择过
                group.add(nums[i]);
                dfs(nums, selected);
                // 回退：恢复未选状态，清除最后一个元素
                selected[i] = false;
                group.remove(group.size() - 1);
            }
        }
    }
}