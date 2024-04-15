class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] strs = s.split(" ");
        if (strs.length != pattern.length()) {
            return false;
        }

        Map<Character, String> char2StrMap = new HashMap<>();
        Map<String, Character> str2CharMap = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String str = strs[i];
            if (!char2StrMap.getOrDefault(c, str).equals(str) || str2CharMap.getOrDefault(str, c) != c) {
                return false;
            }
            char2StrMap.put(c, str);
            str2CharMap.put(str, c);
        }

        return true;
    }
}