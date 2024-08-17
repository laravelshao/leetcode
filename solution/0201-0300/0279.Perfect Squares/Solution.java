class Solution {
    public int numSquares(int n) {
        // 状态定义：dp(i, j) 表示从前 i 个完全评价数中选择个数正好表示整数 j
        // 转移方程：
        // 1、j < i * i：dp(i, j) = dp(i - 1, j)
        // 2、j >= i * i：dp(i, j) = min(dp(i - 1, j), dp(i, j - i * i) + 1)
        // 初始状态：dp(0, 0) = 0
        // 因为 dp(i) 只会用到 dp(i - 1)，所以可以使用一维数组
        // 转移方程简化为：dp(j) = min(dp(j), dp(j - i * i) + 1) j >= i * i
        // dp(0) = 0
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        // 初始状态
        dp[0] = 0;
        for (int i = 1; i * i <= n; i++) {
            for (int j = i * i; j <= n; j++) {
                // 选 或 不选
                dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
            }
        }

        return dp[n];
    }
}