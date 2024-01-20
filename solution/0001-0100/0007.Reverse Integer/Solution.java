class Solution {
    public int reverse(int x) {
        int ans = 0;
        for (; x != 0; x /= 10) {
            // 边界处理，防止乘以10后超过Integer的大小边界
            if (ans < Integer.MIN_VALUE / 10 || ans > Integer.MAX_VALUE / 10) {
                return 0;
            }
            // 第一次：%10获取最后一位，ans=最后一位数字
            // 第二次：%10获取倒数第二位，ans=最后一位*10+倒数第二位
            ans = ans * 10 + x % 10;
        }

        return ans;
    }
}