class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            // 等价于每天都买卖
            int tmpProfit = prices[i] - prices[i - 1];
            if (tmpProfit > 0) {
                profit += tmpProfit;
            }
        }

        return profit;
    }
}