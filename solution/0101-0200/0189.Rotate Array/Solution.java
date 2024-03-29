class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        // k 有可能大于数字长度
        k %= len;

        // 先将数组翻转
        reverse(nums, 0, len - 1);
        // 将前k个元素翻转
        reverse(nums, 0, k - 1);
        // 将剩余元素翻转
        reverse(nums, k, len - 1);
    }

    // 翻转数组
    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int tmp = nums[j];
            nums[j] = nums[i];
            nums[i] = tmp;
            i++;
            j--;
        }
    }
}