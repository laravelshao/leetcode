class Solution {
    public int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> dic = new HashMap<>();

        int i = -1, res = 0;
        for (int j = 0; j < s.length(); j++) {
            // 存在重复字符则更新左指针i
            if (dic.containsKey(s.charAt(j))) {
                i = Math.max(i, dic.get(s.charAt(j)));
            }

            // 更新右指针
            dic.put(s.charAt(j), j);
            res = Math.max(res, j - i);
        }

        return res;
    }
}