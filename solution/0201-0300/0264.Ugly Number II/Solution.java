class Solution {
    public int nthUglyNumber(int n) {
        // 每个丑数都可以由其他较小的丑数通过乘以 2 或 3 或 5 得到
        // 初始状态：dp[1] = 1
        int[] dp = new int[n];
        int a = 0, b = 0, c = 0;
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int next2 = dp[a] * 2, next3 = dp[b] * 3, next5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(next2, next3), next5);
            if(dp[i] == next2) {
                a++;
            }
            if(dp[i] == next3) {
                b++;
            }
            if(dp[i] == next5) {
                c++;
            }
        }

        return dp[n - 1];
    }
}