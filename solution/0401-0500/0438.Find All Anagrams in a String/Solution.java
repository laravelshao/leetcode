class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int m = s.length(), n = p.length();
        List<Integer> ans = new ArrayList<>();
        if (m < n) {
            return ans;
        }

        // 统计字符串 p 中各字符数量
        int[] pCharCount = new int[26];
        for (int i = 0; i < n; i++) {
            pCharCount[p.charAt(i) - 'a']++;
        }

        // 统计当前滑动窗口字符数量
        int[] windowCharCount = new int[26];
        // 双指针指向滑动窗口的左右下标，i：结束下标，j：开始下标
        for (int i = 0, j = 0; i < m; i++) {
            int k = s.charAt(i) - 'a';
            windowCharCount[k]++;
            // 窗口中字符数量大于字符串 p 中指定字符数量
            while (windowCharCount[k] > pCharCount[k]) {
                windowCharCount[s.charAt(j++) - 'a']--;
            }

            if (i - j + 1 == n) {
                ans.add(j);
            }
        }

        return ans;
    }
}