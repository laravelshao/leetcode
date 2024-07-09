class Solution {
    public int lengthOfLastWord(String s) {

        int index = s.length() - 1;
        // 从末尾开始遍历找到最后一个单词的最后一个字母下标
        while (index >= 0 && s.charAt(index) == ' ') {
            index--;
        }

        int wordLen = 0;
        // 继续往前找到第一个空字符的下标，每遍历一次单词长度自增1
        while (index >= 0 && s.charAt(index) != ' ') {
            wordLen++;
            index--;
        }

        return wordLen;
    }
}