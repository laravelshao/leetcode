class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        if(len == 0) {
            return new int[0];
        }

        // 原数组：       [1       2       3       4]
        // 左部分的乘积：   1       1      1*2    1*2*3
        // 右部分的乘积： 2*3*4    3*4      4      1
        // 结果：       1*2*3*4  1*3*4   1*2*4  1*2*3*1
        // 当前位置的结果就是它左部分的乘积再乘以它右部分的乘积。因此需要进行两次遍历，
        // 第一次遍历用于求左部分的乘积，第二次遍历在求右部分的乘积的同时，再将最后的计算结果一起求出来。
        int[] res = new int[len];
        res[0] = 1;
        // 计算当前数左边数乘积
        for(int i = 1; i < len; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        // 计算当前数右边数乘积
        int tmp = 1;
        for(int i = len - 2; i >= 0; i--) {
            // 乘以当前数右边数
            tmp *= nums[i + 1];
            // 左边乘以右边
            res[i] *= tmp;
        }

        return res;
    }
}