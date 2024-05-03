class Solution {
    public int maximalSquare(char[][] matrix) {
        // 状态定义：dp[i, j] 为下标位置(i,j)为右下角，包含1的正方形的边长最大值
        // 转移方程：
        // 1、当 matrix[i][j] = 0，dp[i, j] = 0
        // 2、当 matrix[i][j] = 1，由左方、上方、左上方位置的dp子问题决定，
        // 则 dp[i, j] = min(dp[i, j - 1], dp[i - 1, j], dp[i - 1, j - 1]) + 1
        // 初始状态：首行首列，则以位置 (i,j) 为右下角的最大正方形的边长最大只能是 1，当元素为1时，dp[i, j] = 1

        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        int maxLen = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 元素为1
                if (matrix[i][j] == '1') {
                    // 第一行第一列
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        // 非第一行第一列
                        dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    }
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }

        return maxLen * maxLen;
    }
}