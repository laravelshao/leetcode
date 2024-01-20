class Solution {
    public int lengthOfLongestSubstring(String s) {

        // 双指针，左指针从0开始遍历，右指针初始为-1
        // 第一次左指针为0，则依次自增右指针，如果存放不重复字符集合不存在，则添加进去，右指针++
        // 左指针移动后，则将不重复字符集合中左指针前一位置的字符移除
        Set<Character> exist = new HashSet<>();
        int n = s.length();
        int right = -1, ans = 0;
        for (int left = 0; left < n; left++) {

            // 左指针移动后，需要将左指针前一位置的字符移除
            if (left != 0) {
                exist.remove(s.charAt(left - 1));
            }
            // 当集合中不存在下一个字符时，则添加到exist集合，右指针++
            while (right + 1 < n && !exist.contains(s.charAt(right + 1))) {
                exist.add(s.charAt(right + 1));
                right++;
            }

            // 循环结束，此次循环最长子串长度为 右指针 - 左指针 + 1
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}