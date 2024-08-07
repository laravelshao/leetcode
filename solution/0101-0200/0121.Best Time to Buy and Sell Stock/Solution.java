class Solution {
    public int maxProfit(int[] prices) {

        // 状态定义：dp(i) 代表前 i 天的最大利润，dp(i - 1) 代表前 i - 1 天的最大利润
        // 转移方程：dp(i) = max(dp(i - 1), price - cost)，price - cost：代表第 i 天卖出的最高利润
        // 初始状态：dp(0) = 0
        int cost = Integer.MAX_VALUE, profit = 0;
        for (int price : prices) {
            cost = Math.min(cost, price);
            profit = Math.max(profit, price - cost);
        }

        return profit;
    }
}