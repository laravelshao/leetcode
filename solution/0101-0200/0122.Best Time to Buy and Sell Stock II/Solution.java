class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            // 执行贪心策略，等价于每天都买卖，计算当天与前一天的利润，大于0则累加到总利润
            int tmp = prices[i] - prices[i - 1];
            if (tmp > 0) {
                profit += tmp;
            }
        }

        return profit;
    }
}