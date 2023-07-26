package solution;

/**
 * @author qinghua.shao
 * @date 2023/7/10
 * @since 1.0.0
 */
public class P0014LongestCommonPrefix {


    public static String longestCommonPrefix(String[] strs) {

        // 先确定最短的字符串，因为最小的子串肯定小于等于最短的字符串
        String minStr = strs[0];
        for (String s : strs) {
            if (s.length() < minStr.length()) {
                minStr = s;
            }
        }

        // 从最长子串开始进行比较
        for (int i = minStr.length(); i >= 0; i--) {
            String prefix = minStr.substring(0, i);
            int count = 0;
            for (String s : strs) {
                if (!prefix.equals(s.substring(0, i))) {
                    break;
                }
                count++;
            }

            // 如果个数与数组长度一样，则返回前缀既可
            if (count == strs.length) {
                return prefix;
            }
        }

        return "";
    }

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));
    }
}
