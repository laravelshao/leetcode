class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {

        // 字符次数Map
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        // 遍历赎金信的字符
        for (char c : ransomNote.toCharArray()) {
            if (!charCountMap.containsKey(c)) {
                return false;
            }

            // 剩余字符次数
            int remainCount = charCountMap.get(c) - 1;
            if (remainCount < 0) {
                return false;
            }

            charCountMap.put(c, remainCount);
        }

        return true;
    }
}