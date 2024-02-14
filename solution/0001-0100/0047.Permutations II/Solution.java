class Solution {

    // 结果列表
    private List<List<Integer>> ans = new ArrayList<>();
    // 临时组合
    private List<Integer> tmpCombine = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 0) {
            return ans;
        }

        Arrays.sort(nums);

        // 定义元素是否使用数组
        boolean[] used = new boolean[nums.length];

        dfs(nums, 0, used);

        return ans;
    }

    private void dfs(int[] nums, int depth, boolean[] used) {
        if (depth == nums.length) {
            // 需要做一次拷贝，不然
            ans.add(new ArrayList(tmpCombine));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 当前下标元素未使用 或 (下标大于0 且 前后2个数字相同 且 前一个下标位置未使用过)
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                continue;
            }

            used[i] = true;
            tmpCombine.add(nums[i]);
            dfs(nums, depth + 1, used);
            tmpCombine.remove(tmpCombine.size() - 1);
            used[i] = false;
        }
    }
}