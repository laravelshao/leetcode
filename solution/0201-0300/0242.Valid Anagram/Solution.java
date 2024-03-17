class Solution {
    public boolean isAnagram(String s, String t) {
        // 长度不一致肯定不是
        if(s.length() != t.length()) {
            return false;
        }

        // 字符计数Map<字符、次数>
        Map<Character, Integer> charCntMap = new HashMap<>();
        // 统计第一个字符串字符次数
        for (char c : s.toCharArray()) {
            charCntMap.put(c, charCntMap.getOrDefault(c, 0) + 1);
        }

        // 遍历第二个字符串减去字符次数
        for (char c : t.toCharArray()) {
            if (charCntMap.containsKey(c)) {
                charCntMap.put(c, charCntMap.get(c) - 1);
                if(charCntMap.get(c) == 0) {
                    charCntMap.remove(c);
                }
            }
        }

        // 判断map是否为空
        return charCntMap.isEmpty();
    }
}