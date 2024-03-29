class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {

        // 参考题解：https://leetcode.cn/problems/triangle/solutions/329394/di-gui-ji-yi-hua-dp-bi-xu-miao-dong-by-sweetiee/?envType=study-plan-v2&envId=top-interview-150
        
        // 状态定义：dp[i, j] 表示从点(i,j)到底边的最小路径和
        // 转移方程：dp[i, j] = min(dp[i + 1, j], dp[i + 1, j + 1]) + triangle[i][j]
        int n = triangle.size();
        // 防止越界
        int[][] dp = new int[n + 1][n + 1];

        for(int i = n - 1; i >= 0; i--) {
            for(int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }

        return dp[0][0];
    }
}