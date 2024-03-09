class Solution {
    public int rob(int[] nums) {

        // 状态：dp(n) 代表前 n 间房偷的最高金额
        // 因为不能偷相邻房屋，分2种情况：
        // 不偷第 n + 1 间房，dp(n+1) = dp(n)
        // 偷第 n + 1 间房，则第 n 间房不能偷，dp(n+1) = dp(n-1) + num[n]
        // 转移方程：dp(n+1) = max(dp(n - 1), dp(n) + num[n])
        // 初始状态：前 0 间房最高金额为 0
        // 因为 dp(n) 只和 dp(n-1)、dp(n-2)有关，直接利用2个变量交替记录
        int pre = 0, cur = 0, tmp;
        for(int num : nums) {
            tmp = cur;
            cur = Math.max(pre + num, cur);
            pre = tmp;
        }

        return cur;
    }
}