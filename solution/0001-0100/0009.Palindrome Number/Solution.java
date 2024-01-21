class Solution {
    public boolean isPalindrome(int x) {

        // 负数 或 正数且位数为0肯定不是回文
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }

        // 翻转后半部分数字与前半部分比较
        int revertedNum = 0;
        while (revertedNum < x) {
            revertedNum = revertedNum * 10 + x % 10;
            x = x / 10;
        }

        // 对于数字长度为偶数，终止条件为前半部分与翻转后后半部分一致
        // 对于数字长度为奇数，终止条件为翻转后半部分大于前半部分1位
        return x == revertedNum || x == revertedNum / 10;
    }
}