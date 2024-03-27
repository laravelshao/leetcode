class Solution {
    public int integerBreak(int n) {
        // 拆分规则：
        // 最优：3，把数字 n 可能拆为多个因子 3，余数可能为 0,1,2 三种情况。
        // 次优：2，若余数为 2；则保留，不再拆为 1+1 。
        // 最差：1，若余数为 1；则应把一份 3+1 替换为 2+2，因为 2×2>3×1。
        if(n <= 3) {
            return n - 1;
        }

        int a = n / 3, b = n % 3;
        if(b == 0) {
            return (int)Math.pow(3, a);
        } else if(b == 1) {
            // 余数为1时，则将最后一个3和1 替换为2*2
            return (int)Math.pow(3, a - 1) * 4;
        } else {
            return (int)Math.pow(3, a) * 2;
        }
    }
}