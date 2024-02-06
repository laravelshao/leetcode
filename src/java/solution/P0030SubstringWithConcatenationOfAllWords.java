package solution;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 30. Substring with Concatenation of All Words
 *
 * @author qinghua.shao
 * @date 2024/2/6
 * @since 1.0.0
 */
public class P0030SubstringWithConcatenationOfAllWords {

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        // wordNum：单词个数 wordLen：数组单词长度 stringLen：给定字符串长度
        int wordNum = words.length, wordLen = words[0].length(), stringLen = s.length();

        for (int i = 0; i < wordLen; i++) {
            // 遍历的长度超过给定字符串长度则结束循环
            if (i + wordNum * wordLen > stringLen) {
                break;
            }

            // differ：表示窗口中的单词频次和words中的单词频次之差
            Map<String, Integer> differ = new HashMap<>();
            // 初始化窗口，窗口长度为m * wordLen,依次计算窗口里每个切分的单词的频次
            for (int j = 0; j < wordNum; j++) {
                String word = s.substring(i + j * wordLen, i + (j + 1) * wordLen);
                differ.put(word, differ.getOrDefault(word, 0) + 1);
            }
            // 遍历words中的word，对窗口里每个单词计算差值
            for (String word : words) {
                differ.put(word, differ.getOrDefault(word, 0) - 1);
                // 差值为0时，移除掉这个word
                if (differ.get(word) == 0) {
                    differ.remove(word);
                }
            }
            // 开始滑动窗口
            for (int start = i; start < stringLen - wordNum * wordLen + 1; start += wordLen) {
                if (start != i) {
                    // 右边的单词滑进来
                    String word = s.substring(start + (wordNum - 1) * wordLen, start + wordNum * wordLen);
                    differ.put(word, differ.getOrDefault(word, 0) + 1);
                    if (differ.get(word) == 0) {
                        differ.remove(word);
                    }
                    // 左边的单词滑出去
                    word = s.substring(start - wordLen, start);
                    differ.put(word, differ.getOrDefault(word, 0) - 1);
                    if (differ.get(word) == 0) {
                        differ.remove(word);
                    }
                    word = s.substring(start - wordLen, start);
                }
                // 窗口匹配的单词数等于words中对应的单词数
                if (differ.isEmpty()) {
                    ans.add(start);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        String s = "barfoofoobarthefoobarman";
        String[] words = new String[]{"bar", "foo", "the"};

        List<Integer> ans = findSubstring(s, words);
        System.out.println(ans);
    }
}
