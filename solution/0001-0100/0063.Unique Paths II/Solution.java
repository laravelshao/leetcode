class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        // 状态定义：dp[i, j] 为指定索引下标的路径数，只能由左或上移动
        // 转移方程：dp[i, j] = dp[i, j - 1] + dp[i - 1, j] 
        // 初始状态：第一行第一列，碰到障碍物(1)后停止 dp[0, j] = 1，dp[i, 0] = 1
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        // 填充第一列初始值，碰到障碍物后停止
        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }

        // 填充第一行初始值，碰到障碍物后停止
        for (int j = 0; j < n && obstacleGrid[0][j] == 0; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 该下标位置不是障碍物
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}