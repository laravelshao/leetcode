class Solution {
    public String countAndSay(int n) {
        String s = "1";
        // 因为初始字符串算第1次，所以剩下3次
        while (--n > 0) {
            StringBuilder t = new StringBuilder();
            // 遍历字符串
            for (int i = 0; i < s.length(); ) {
                int j = i;
                // 判断重复字符的数量
                while (j < s.length() && s.charAt(i) == s.charAt(j)) {
                    j++;
                }
                t.append((j - i) + ""); // 组装字符个数
                t.append(s.charAt(i)); // 字符
                i = j;
            }
            s = t.toString();
        }
        return s;
    }
}