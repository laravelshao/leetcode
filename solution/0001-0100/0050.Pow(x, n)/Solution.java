class Solution {
    public double myPow(double x, int n) {
        // 如果n是-2^31，-n则会超过int的最大边界，利用long接收
        long N = n;
        return N > 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }
    private double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }

        double y = quickMul(x, N / 2);
        // 如果N%2不等于0，需要额外乘以x
        return N % 2 == 0 ? y * y : y * y * x;
    }
}