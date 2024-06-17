class Solution {
    public int maxSubArray(int[] nums) {
        // 状态定义：dp[i] 代表以 nums[i] 作为结尾最大和连续子数组
        // 解释：如果前置dp[i-1]是负数，加上nums[i]只会更小，所以从当前元素开始从新统计
        // 转移方程：dp[i] = max(dp[i - 1] + nums[i], nums[i])
        // 初始状态：dp[0] = nums[0];
        int ans = nums[0];
        int dp = nums[0];
        for(int i = 1; i < nums.length; i++) {
            dp = Math.max(dp + nums[i], nums[i]);
            ans = Math.max(ans, dp);
        }

        return ans;
    }
}