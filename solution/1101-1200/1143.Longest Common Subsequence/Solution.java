class Solution {
    public int longestCommonSubsequence(String text1, String text2) {

        // 状态定义：dp(i, j) 表示字符串 text1前i个字符 和 text2前j个字符的最长公共子序列
        // 转移方程：
        // 1、当 text1[i−1] = text2[j−1] 时，dp(i, j) = dp(i - 1, j - 1) + 1
        // 2、当 text1[i−1] != text2[j−1] 时，dp(i, j) = max(dp(i - 1, j), dp(i, j - 1))
        // 初始状态：i = 0 或 j = 0 时，dp(i, j) = 0

        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 1; i <= m; i++) {
            char c1 = text1.charAt(i - 1);
            for(int j = 1; j <= n; j++) {
                char c2 = text2.charAt(j - 1);
                if(c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }
}