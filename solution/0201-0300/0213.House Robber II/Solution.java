class Solution {
    public int rob(int[] nums) {

        // 因为头尾房间相连，则有2种情况：
        // 第 1 个房间不偷，最高金额为 p1
        // 最后一个房间不偷，最高金额为 p2
        // max(p1, p2)
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        return Math.max(myRob(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                myRob(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    // 转换为单排排列问题，LC198场景
    public int myRob(int[] nums) {

        // 状态：dp(n) 代表前 n 间房偷的最高金额
        // 因为不能偷相邻房屋，分2种情况：
        // 不偷第 n + 1 间房，dp(n+1) = dp(n)
        // 偷第 n + 1 间房，则第 n 间房不能偷，dp(n+1) = dp(n-1) + num[n]
        // 转移方程：dp(n+1) = max(dp(n - 1), dp(n) + num[n])
        // 初始状态：前 0 间房最高金额为 0
        // 因为 dp(n) 只和 dp(n-1)、dp(n-2)有关，直接利用2个变量交替记录
        int pre = 0, cur = 0, tmp;
        for (int num : nums) {
            tmp = cur;
            cur = Math.max(pre + num, cur);
            pre = tmp;
        }

        return cur;
    }
}