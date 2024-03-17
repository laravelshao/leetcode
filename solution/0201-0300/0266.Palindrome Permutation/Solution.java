class Solution {
    public boolean canPermutePalindrome(String s) {
        // 注意事项：字符串的某个排列是否是回文串，不是字符串本身是回文串
        // 回文有2种情况：
        // 1、字符数为偶数位，每个字符都出现偶数次数
        // 2、字符数为奇数位，仅有一个字符是奇数次数
        Map<Character, Integer> charCntMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            charCntMap.put(c, charCntMap.getOrDefault(c, 0) + 1);
        }

        // 统计基数次数字符个数
        int odds = 0;
        for (int i : charCntMap.values()) {
            if (i % 2 == 1) {
                // 奇数次数字符个数大于1则不是回文串
                if (++odds > 1) {
                    return false;
                }
            }
        }

        return true;
    }
}