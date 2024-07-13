class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return new int[0];
        }

        // 原数组：       [1       2       3       4]
        // 左部分的乘积：   1       1      1*2    1*2*3
        // 右部分的乘积： 2*3*4    3*4      4      1
        // 结果：       1*2*3*4  1*3*4   1*2*4  1*2*3*1
        // 当前位置的结果就是它左部分的乘积再乘以它右部分的乘积。因此需要进行两次遍历，
        // 第一次遍历用于求左部分的乘积，第二次遍历在求右部分的乘积的同时，再将最后的计算结果一起求出来。
        int[] ans = new int[n];
        ans[0] = 1;
        // 计算当前数左边数乘积
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }

        // 计算当前数右边数乘积，并乘以左边乘积
        int right = 1;
        // 当前下标在最后一个下标，就等于左边的乘积，无需遍历，所以起始下标从 n - 2 开始
        for (int i = n - 2; i >= 0; i--) {
            // 乘以当前数右边数
            right *= nums[i + 1];
            // 左边乘以右边
            ans[i] *= right;
        }

        return ans;
    }
}