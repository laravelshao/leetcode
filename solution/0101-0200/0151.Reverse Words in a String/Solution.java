class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        StringBuilder res = new StringBuilder();
        int j = s.length() - 1, i = j;
        while (i >= 0) {
            // 从后往前判断下一个字符为空的位置
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            // subString()：包左不包右
            res.append(s.substring(i + 1, j + 1) + " ");
            // 往前遍历到不为空的下标位置
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }

            // 将前一个单词的结束下标赋值给j
            j = i;
        }

        return res.toString().trim();
    }
}