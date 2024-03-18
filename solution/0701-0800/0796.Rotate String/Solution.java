class Solution {
    public boolean rotateString(String s, String goal) {
        // 字符串长度一致 且 某个字符串拼接2次肯定包含另一字符串 则满足条件
        return s.length() == goal.length() && (goal + goal).contains(s);
    }
}