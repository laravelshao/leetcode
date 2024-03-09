class Solution {
    public int fib(int n) {
        // 初始状态 f(0) = 0, f(1) = 1
        // 状态转移方程：f(n) = f(n - 1) + f(n - 2)
        int a = 0, b = 1, sum;
        for(int i = 0; i < n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }

        return a;
    }
}