class Solution {
    public int longestPalindrome(String s) {

        // 统计字符个数
        HashMap<Character, Integer> charCntMap = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            charCntMap.put(c, charCntMap.getOrDefault(c, 0) + 1);
        }

        // 统计构造回文串的最大长度
        int res = 0, odd = 0; // 奇数标识
        for(Map.Entry<Character, Integer> entry : charCntMap.entrySet()) {
            // 当前字符出现次数向下取偶数，并计入 res
            int cnt = entry.getValue();
            int remain = cnt % 2;
            res += cnt - remain;
            // 当前字符出现次数为奇数时，将 odd 置为 1
            if(remain == 1) {
                odd = 1;
            }
        }

        // 所有字符向下取偶数之和+1(如果存在奇数次数字符)
        return res + odd;
    }
}