class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        // 原地哈希：将指定的数 x 交换到下标为 x - 1 的位置
        // 没有出现的最小正整数只会在[1, n + 1] 之间
        // 如果 [1, n] 都出现了，那么答案是 n + 1；否则答案是 [1, n] 中没有出现的最小正整数
        for (int i = 0; i < n; i++) {
            // 在[1, n]之间 且 当前数 nums[i] 未待在该待的 nums[i] - 1 下标处
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            // 未待在其指定下标位置，缺失的就是最小正整数
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // 交换之后都待在正确的位置没有缺失
        return n + 1;
    }
}