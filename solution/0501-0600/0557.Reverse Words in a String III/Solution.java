class Solution {
    public String reverseWords(String s) {

        String[] parts = s.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < parts.length; i++) {
            String str = parts[i];
            // 倒序拼接
            for (int j = str.length() - 1; j >= 0; j--) {
                result.append(str.charAt(j));
            }

            // 每个单词添加空格分隔(最后一个无需添加)
            if (i < parts.length - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }
}