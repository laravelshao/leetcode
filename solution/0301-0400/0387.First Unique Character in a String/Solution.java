class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> charCntMap = new HashMap<>();
        // 统计字符次数
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            charCntMap.put(c, charCntMap.getOrDefault(c, 0) + 1);
        }
        // 顺序遍历判断字符次数是否等于1
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (charCntMap.get(c) == 1) {
                return i;
            }
        }

        return -1;
    }
}