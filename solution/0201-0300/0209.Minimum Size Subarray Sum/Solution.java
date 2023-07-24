class Solution {
    /**
     * 双指针方式
     */
    public int minSubArrayLen(int target, int[] nums) {
        // length：数组长度 minLength：最小长度
        int length = nums.length, minLength = nums.length + 1;
        long sum = 0;
        for (int i = 0, j = 0; i < length; ++i) {
            sum += nums[i];
            while (j < length && sum >= target) {
                // 当双指针窗口中累加 >= target，则计算最小长度
                minLength = Math.min(minLength, i - j + 1);
                // j = 0 从左开始一个一个移除元素
                sum -= nums[j++];
            }
        }
        return minLength <= length ? minLength : 0;
    }
}