class Solution {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0 || s.trim().length() == 0) {
            return 0;
        }
        s = s.trim();
        if (!Character.isDigit(s.charAt(0))
                && s.charAt(0) != '-' && s.charAt(0) != '+') {
            return 0;
        }

        // 利用long承载防止超出int的上下边界
        long ans = 0;
        boolean neg = (s.charAt(0) == '-');
        // 获取数字的起始idx
        int start = Character.isDigit(s.charAt(0)) ? 0 : 1;
        while (start < s.length() && Character.isDigit(s.charAt(start))) {
            ans = ans * 10 + (s.charAt(start++) - '0');
            // 边界值处理
            if (!neg && ans > Integer.MAX_VALUE) {
                ans = Integer.MAX_VALUE;
                break;
            }
            if (neg && ans > Integer.MAX_VALUE + 1L) {
                ans = Integer.MAX_VALUE + 1L;
                break;
            }
        }

        return neg ? (int) -ans : (int) ans;
    }
}