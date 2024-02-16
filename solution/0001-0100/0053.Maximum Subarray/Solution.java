class Solution {
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        // f(i)：第i个数结尾的连续子数组的最大和
        int f = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 如果前置f(i-1)是负数，加上nums[i]只会更小，所以从当前元素开始从新统计
            f = Math.max(f + nums[i], nums[i]);
            ans = Math.max(ans, f);
        }
        return ans;
    }
}