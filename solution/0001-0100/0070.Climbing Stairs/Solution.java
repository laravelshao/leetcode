class Solution {
    public int climbStairs(int n) {
        if(n == 1 || n == 2) {
            return n;
        }

        // 动态转移方程：dp(n) = dp(n - 1) + dp(n - 2)
        // 初始状态：dp(1) = 1, dp(2) = 2
        int a = 1, b = 2;
        for(int i = 3; i <= n; i++) {
            int tmp = b;
            b = a + b;
            a = tmp;
        }

        return b;
    }
}