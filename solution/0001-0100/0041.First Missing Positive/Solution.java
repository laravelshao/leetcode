class Solution {
    public int firstMissingPositive(int[] nums) {

        int n = nums.length;
        // 原地哈希，将指定的数 x 交换到下标为 x - 1 的位置
        // 对于一个长度为 N 的数组，其中没有出现的最小正整数只能在 [1,N+1] 中。这是因为
        // 如果 [1,N] 都出现了，那么答案是 N+1，否则答案是 [1,N] 中没有出现的最小正整数。
        for (int i = 0; i < n; i++) {
            // 在[1, n]之间 且 当前数 nums[i] 未待在该待的 nums[i] - 1 下标处
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // 交换之后都待在正确的位置没有缺失
        return n + 1;
    }
}