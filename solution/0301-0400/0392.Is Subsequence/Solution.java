class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0) {
            return true;
        }

        // i：字符串t索引下标
        // j：字符串s索引下标
        for (int i = 0, j = 0; i < t.length(); i++) {
            if (s.charAt(j) == t.charAt(i)) {
                // 字符串s遍历结束则提前结束
                if (++j == s.length()) {
                    return true;
                }
            }
        }

        return false;
    }
}