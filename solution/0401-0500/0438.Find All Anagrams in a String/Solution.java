class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        int m = s.length(), n = p.length();
        List<Integer> ans = new ArrayList<>();
        if (m < n) {
            return ans;
        }

        // 统计字符串 p 中各字符数量
        int[] pCharCnt = new int[26];
        for (char c : p.toCharArray()) {
            pCharCnt[c - 'a']++;
        }

        // 统计当前窗口内字符数量
        int[] windowCharCnt = new int[26];
        // 双指针指向滑动窗口左右下标，left：开始下标 right：结束下标
        for (int right = 0, left = 0; right < m; right++) {
            int k = s.charAt(right) - 'a';
            windowCharCnt[k]++;
            // 窗口中字符数量大于字符串 p 中指定字符数量，则说明：
            // 1、出现了p中没有的字符 eg: s=cbae p=abc，指针到s中的e时，
            // windowCharCnt['e'-'a'] = 1 > pCharCnt['e'-'a'] = 0
            // 2、出现了s中这个字符大于p中这个字符数量
            // 所以需要移动左下标缩小窗口，因为我们窗口只匹配完全对应p的
            while (windowCharCnt[k] > pCharCnt[k]) {
                windowCharCnt[s.charAt(left++) - 'a']--;
            }

            if (right - left + 1 == n) {
                ans.add(left);
            }
        }

        return ans;
    }
}