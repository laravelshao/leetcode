package solution.part01;

/**
 * 5.Longest Palindromic Substring
 *
 * @author qinghua.shao
 * @date 2023/7/12
 * @since 1.0.0
 */
public class P0005LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {

        // 字符串长度
        int n = s.length();
        // start为最长回文串起始索引，mx为最长回文串长度
        int start = 0, mx = 1;
        for (int i = 0; i < n; i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > mx) {
                mx = len;
                start = i - (len - 1) / 2;
            }
        }

        return s.substring(start, start + mx);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }
}
