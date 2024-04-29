class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // 状态定义：dp[i] 为字符串前i个字符串[0, i - 1]是否可以由 wordDict 中的字符串组成
        // 转移方程：dp[i] = dp[j] && wordDict是否包含子字符串s[j, i - 1]
        // 初始状态：dp[0] = true，代表空字符串
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true; // 初始状态
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                // substring：截取包括左下标不包含右下标[j, i - 1]
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}