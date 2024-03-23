class Solution {
    public double myPow(double x, int n) {
        // 如果n是-2^31，-n则会超过int的最大边界，利用long接收
        long l = n;
        return l > 0 ? quickMul(x, l) : 1 / quickMul(x, -l);
    }

    private double quickMul(double x, long n) {
        if (n == 0) {
            return 1.0;
        }

        double y = quickMul(x, n / 2);
        // 如果N%2不等于0，需要额外乘以x
        return n % 2 == 0 ? y * y : y * y * x;
    }
}