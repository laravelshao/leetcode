class Solution {

    // 结果列表
    private List<List<Integer>> ans = new ArrayList<>();
    // 临时组合
    private List<Integer> tmpCombine = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return ans;
        }

        // 定义元素是否使用数组
        boolean[] used = new boolean[nums.length];

        dfs(nums, 0, used);

        return ans;
    }

    private void dfs(int[] nums, int depth, boolean[] used) {
        if (depth == nums.length) {
            // 需要做一次拷贝，不能直接添加；不然回溯时会全部清空
            ans.add(new ArrayList(tmpCombine));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 当前元素还未被使用
            if (!used[i]) {
                used[i] = true;
                tmpCombine.add(nums[i]);
                dfs(nums, depth + 1, used);
                tmpCombine.remove(tmpCombine.size() - 1);
                used[i] = false;
            }
        }
    }
}