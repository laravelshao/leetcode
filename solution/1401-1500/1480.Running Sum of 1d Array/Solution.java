class Solution {
    public int[] runningSum(int[] nums) {

        // 动态转移方程：dp(i) = dp(i - 1) +nums[i]
        // 初始状态：dp(0) = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i - 1] + nums[i];
        }

        return dp;
    }
}