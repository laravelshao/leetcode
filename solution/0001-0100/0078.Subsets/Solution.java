class Solution {

    private List<List<Integer>> ans = new ArrayList<>();

    private List<Integer> group = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0);
        return ans;
    }

    private void dfs(int[] nums, int index) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(group));
            return;
        }

        // 做出选择，选择当前元素进行递归
        group.add(nums[index]);
        // 递归调用
        dfs(nums, index + 1);
        // 回退选择
        group.remove(group.size() - 1);
        // 不选择当前元素递归
        dfs(nums, index + 1);
    }
}