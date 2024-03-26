class Solution {
    public int singleNumber(int[] nums) {
        // 相同数字异或运算等于0
        int res = 0;
        for (int num : nums) {
            res ^= num; // 执行异或运算
        }

        return res;
    }
}