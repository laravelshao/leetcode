class Solution {
    public String longestCommonPrefix(String[] strs) {

        // 先确定最短的字符串，因为最小子串肯定小于等于最短字符串
        String minStr = strs[0];
        for (String s : strs) {
            if (s.length() < minStr.length()) {
                minStr = s;
            }
        }

        // 遍历该子串，从末尾依次减少一个字符，然后和字符串数组的前缀进行比较
        for (int i = minStr.length(); i >= 0; i--) {
            String prefix = minStr.substring(0, i);
            // 判断前缀相同的个数，如果个数和字符串数组长度一样，则返回该子串前缀，否则继续减少字符
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
}