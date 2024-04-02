class Solution {
    public int minDistance(String word1, String word2) {
        // 状态定义：dp[i, j] 表示将word1的前i个字符更改为word2的前j个字符所需的最少编辑步数
        // 针对子问题dp[i, j]，其对应的2个字符串尾部字符word1[i - 1] 和 word2[j - 1]
        // 1、在word1[i - 1]后添加word2[j - 1]，则剩余子问题为 dp[i, j - 1]
        // 2、删除word1[i - 1]，则剩余子问题为 dp[i - 1][j]
        // 3、将word1[i - 1]替换为word2[j - 1]，剩余子问题为 dp[i - 1][j - 1]
        // 转移方程：dp[i, j] = min(dp[i, j - 1], dp[i - 1, j], dp[i - 1, j - 1]) + 1
        // 字符word1[i - 1] 和 word2[j - 1] 一致时，dp[i, j] = dp[i - 1, j - 1]
        // 初始状态：
        // 1、当两个字符串都为空时，dp[0][0] = 0
        // 2、当word1字符串为空时，最少编辑步数等于word2的长度，首行为空，dp[0][j] = j
        // 3、当word2字符串为空时，最少编辑步数等于word1的长度，首列为空，dp[i][0] = i

        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        // 填充首列初始状态
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }

        // 填充首行初始状态
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }

        return dp[m][n];
    }
}