class Solution {
    /**
     * 方法一：动态规划
     */
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        int n = s.length();
        // 状态定义：dp[i, j] 表示 s[i, j] 是否为回文串
        // 转移方程：当s[i] == s[j] 时，则 dp[i, j] = dp[i + 1, j - 1]
        // 初始状态：全部元素为 true
        boolean[][] dp = new boolean[n][n];
        for (boolean[] array : dp) {
            Arrays.fill(array, true);
        }

        // start：最长回文串起始位置，maxLen：最长回文串长度
        int start = 0, maxLen = 1;
        // 因为 dp[i][j] 依赖 dp[i + 1][j - 1]，所以需要 i 需要从大到小遍历，j 需要从小到大遍历
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = false;
                // 下标 i 位置字符等于下标 j 位置字符
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                    // 是回文串 且 回文串长度大于 maxLen
                    if (dp[i][j] && j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        start = i;
                    }
                }
            }
        }

        return s.substring(start, start + maxLen);
    }
}