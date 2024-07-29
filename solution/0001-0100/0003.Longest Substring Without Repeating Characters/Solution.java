class Solution {
    public int lengthOfLongestSubstring(String s) {

        // 记录字符最后一次出现下标位置
        Map<Character, Integer> dic = new HashMap<>();

        // 定义双指针，i/j 表示不重复子串窗口的开始结束位置
        int i = -1, ans = 0;
        for (int j = 0; j < s.length(); j++) {

            // 存在重复字符则更新左指针i
            if (dic.containsKey(s.charAt(j))) {
                i = Math.max(i, dic.get(s.charAt(j)));
            }
            // 更新右指针
            dic.put(s.charAt(j), j);
            ans = Math.max(ans, j - i);
        }

        return ans;
    }
}