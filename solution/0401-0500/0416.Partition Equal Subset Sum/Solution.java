class Solution {
    public boolean canPartition(int[] nums) {

        // 状态定义：dp(i, j) 表示从数组下标[0, i]中选择若干个数的总和是否存在为 j
        // 转移方程：dp(i, j) = dp(i - 1, j) || dp(i - 1, j - nums[i])
        // 1、选择了下标为 i 的数 nums[i]，dp(i, j) = dp(i - 1, j - nums[i])
        // 2、未选择下标为 i 的数 nums[i]，dp(i, j) = dp(i - 1, j)
        // 初始状态：dp(0, 0) = true
        // 因为每一行的 dp 值只与上一行的 dp 值有关，可使用一维数组，
        // 转移方程为：dp(j) = dp(j) || dp(j - nums[i])
        int s = 0;
        for (int num : nums) {
            s += num;
        }

        // 总和是奇数则直接返回
        if (s % 2 != 0) {
            return false;
        }
        // 减半
        int target = s / 2;

        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int x : nums) {
            // 需要从大到小遍历计算 dp 值，因为计算 dp[j] 时，dp[j - nums[i]] 已经是被更新过的状态，而不是上一行的 dp 值
            for (int j = target; j >= x; j--) {
                dp[j] = dp[j] || dp[j - x];
            }
        }

        return dp[target];
    }
}