class Solution {
    public int lengthOfLongestSubstring(String s) {

        // 记录字符最后一次出现下标位置
        Map<Character, Integer> charIdxMap = new HashMap<>();

        // 定义双指针，i/j 表示不重复子串窗口的开始结束位置
        int i = -1, ans = 0;
        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            // 存在重复字符则更新左指针i
            if (charIdxMap.containsKey(c)) {
                i = Math.max(i, charIdxMap.get(c));
            }
            // 更新右指针
            charIdxMap.put(c, j);
            ans = Math.max(ans, j - i);
        }

        return ans;
    }
}