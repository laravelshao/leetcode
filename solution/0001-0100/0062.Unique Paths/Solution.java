class Solution {
    /**
     * 状态转移方程：dp(i,j)=dp(i-1,j)+dp(i,j-1)
     */
    public int uniquePaths(int m, int n) {
        int[] f = new int[n];

        // 将第一行元素初始化为1
        for(int i = 0; i < n; i++) {
            f[i] = 1;
        }

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                f[j] += f[j - 1];
            }
        }

        return f[n - 1];
    }
}