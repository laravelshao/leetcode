class Solution {
    public void reverseString(char[] s) {

        for (int head = 0, tail = s.length - 1; head < tail; head++, tail--) {
            // 获取尾部元素
            char tmp = s[tail];
            // 将头部元素赋值尾部元素
            s[tail] = s[head];
            // 将尾部元素赋值头部元素
            s[head] = tmp;
        }
    }
}