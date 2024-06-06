class Solution {
    public int coinChange(int[] coins, int amount) {
        // 状态定义：dp[i] = 表示凑足金额i的最少硬币数
        // 转移方程：dp[i] = min(dp[i], dp[i- coins[j]] + 1)，j ∈ [0, coins.length - 1]
        // 包含2种情况：
        // 1、不选当前硬币，为 dp[i]
        // 2、选择当前硬币，剩余金额为i-coins[j]，硬币数为 dp[i - coins[j]] + 1
        // 初始状态：dp[0] = 0
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for(int i = 1; i <= amount; i++) {
            for(int j = 0; j < coins.length; j++) {
                if(coins[j] <= i) {
                    // 包含2种情况：
                    // 1、不选当前硬币，为 dp[i]
                    // 2、选择当前硬币，剩余金额为i-coins[j]，硬币数为 dp[i - coins[j]] + 1
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        return dp[amount] == max ? -1 : dp[amount];
    }
}