class Solution {
    public int trailingZeroes(int n) {

        // 阶乘中0的数量，就是10的个数，而 10=2×5，因此转换成求 n! 中质因子 2 的个数和质因子 5 的个数的较小值
        // 因为 5 的个数小于 2的个数，所以可以只求 5的个数
        int ans = 0;
        while (n != 0) {
            n /= 5;
            ans += n;
        }

        return ans;
    }
}