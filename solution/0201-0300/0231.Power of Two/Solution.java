class Solution {
    public boolean isPowerOfTwo(int n) {
        // 若 n=2^x（即 n 为 2 的幂），则一定满足以下条件：
        // 1、恒有 n & (n - 1) == 0，这是因为：
        // - n 二进制最高位为 1，其余所有位为 0；
        // - n−1 二进制最高位为 0，其余所有位为 1；
        // 2、一定满足 n > 0。
        return n > 0 &&(n & (n - 1)) == 0;
    }
}