class Solution {
    public int uniquePaths(int m, int n) {
        // 状态定义：dp(i, j) 表示达到下标(i, j)的路径数
        // 转移方程：dp(i, j) = dp(i - 1, j) + dp(i, j - 1)
        // 初始状态：首行首列都为1
        // 因为dp(i) 只和dp(i - 1)相关，可以简化为一维数组
        // 转移方程：dp(i) = dp(i) + dp(i - 1)
        int[] dp = new int[n];
        // 初始化第一行为1
        Arrays.fill(dp, 1);

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }

        return dp[n - 1];
    }
}