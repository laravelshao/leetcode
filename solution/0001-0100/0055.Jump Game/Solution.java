class Solution {
    public boolean canJump(int[] nums) {
        // 状态定义：dp(i) 代表下标i能够到达的最远下标
        // 转移方程：dp(i) = max(dp(i - 1), i + nums[i]);
        // 初始状态：dp(0) = 0
        int dp = 0;
        for(int i = 0; i < nums.length; i++) {
            // 最远下标小于当前位置说明不可达
            if(dp < i) {
                return false;
            }
            dp = Math.max(dp, i + nums[i]);
        }
        return true;
    }
}