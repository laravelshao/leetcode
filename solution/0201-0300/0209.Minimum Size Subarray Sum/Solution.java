class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        int ans = Integer.MAX_VALUE;
        // start、end 对应滑动窗口的起始结束位置
        int start = 0, end = 0, sum = 0;
        while (end < n) {
            sum += nums[end];
            // 当双指针窗口中累加 >= target，则计算最小长度
            while (sum >= target) {
                ans = Math.min(ans, end - start + 1);
                // 从左开始一个一个移除元素
                sum -= nums[start];
                start++;
            }
            end++;
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}