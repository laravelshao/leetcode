class Solution {
    public int minPathSum(int[][] grid) {

        int rows = grid.length; // 行
        int columns = grid[0].length; // 列
        /**
         * 第一列：i > 0 且 j = 0, dp[i][0] = dp[i-1][0] + grid[i][0]
         * 第一行：i = 0 且 j > 0, dp[0][j] = dp[0][j-1] + grid[0][j];
         * 其它：i > 0 且 j > 0, dp[i][j] = min(dp[i][j-1], dp[i-1][j]) + grid[i][j];
         */
        int[][] dp = new int[rows][columns];
        dp[0][0] = grid[0][0];

        // 第一列
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        // 第一行
        for (int j = 1; j < columns; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        // 其它
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[rows - 1][columns - 1];
    }
}