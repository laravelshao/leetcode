class Solution {

    // 结果列表
    private List<List<Integer>> ans = new ArrayList<>();
    // 临时组合
    private List<Integer> group = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 0) {
            return ans;
        }

        boolean[] selected = new boolean[nums.length];
        dfs(nums, selected);
        return ans;
    }

    private void dfs(int[] nums, boolean[] selected) {
        // 终止条件：组合元素已达到数组长度
        if(group.size() == nums.length) {
            ans.add(new ArrayList<Integer>(group));
            return;
        }

        Set<Integer> exist = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            // 剪枝：元素未选择过 且 不存在相同元素
            if(!selected[i] && !exist.contains(nums[i])) {
                selected[i] = true; // 标记已选
                exist.add(nums[i]);
                group.add(nums[i]);
                // 向下一轮选择
                dfs(nums, selected);
                // 回退：标记恢复未选择，移除最后一个元素
                selected[i] = false;
                group.remove(group.size() - 1);
            }
        }
    }
}