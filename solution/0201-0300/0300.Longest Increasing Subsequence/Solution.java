class Solution {
    public int lengthOfLIS(int[] nums) {
        // 状态定义：dp[i] 代表前 i 个元素的最长递增子序列长度
        // 当 j in [0, i)时：
        // nums[i] > nums[j]，代表 nums[i] 可以接在 nums[j] 后面，
        // 最长上升子序列长度 dp[j] + 1
        // nums[i] <= nums[j]，代表 nums[i] 不能接在 nums[j] 后面，忽略
        // 转移方程：dp[i] = max(dp[i], dp[j] + 1)  j for in [0, i)
        // 初始状态：dp[i] 每个元素都为 1，代表每个元素都可以单独成为子序列
        if(nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1); // 初始全部填充为1

        int ans = 0;
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }
}