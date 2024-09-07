class Solution {
    public int minPathSum(int[][] grid) {

        // 状态定义：dp[i, j] 表示下标位置(i, j)的最小路径和
        // 解释：只能由上面或左边移动
        // 转移方程：dp[i, j] = min(dp[i - 1, j], dp[i, j - 1]) + grid[i][j]
        // 初始状态：第一行只能向右移动，第一列只能向下移动

        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        // 初始化首行、首列
        dp[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[m - 1][n - 1];
    }
}