class Solution {
    public void rotate(int[] nums, int k) {

        int n = nums.length;
        if(n == 1) {
            return;
        }

        // k 是 n 的倍数，则无需轮转
        k %= n;
        if(n == 0) {
            return;
        }

        // 先将数组翻转
        reverse(nums, 0, n - 1);
        // 将前k个元素翻转
        reverse(nums, 0, k - 1);
        // 将剩余元素翻转
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }
}