class Solution {
    public int findNthDigit(int n) {
        int start = 1; // 起始数
        long digit = 1; // 位数
        long count = 9; // 当前号段数字总计数
        while (n > count) {
            n -= count; // 减去当前号段数字总位数
            start *= 10; // 起始值放大10倍
            digit += 1; // 位数加1
            count = digit * start * 9; // 更新号段数字总计数
        }

        // 确定所求数位所在的数字
        long num = start + (n - 1) / digit;
        // 确定所求数位在 num 的哪一数位
        return Long.toString(num).charAt((n - 1) % (int)digit) - '0';
    }
}