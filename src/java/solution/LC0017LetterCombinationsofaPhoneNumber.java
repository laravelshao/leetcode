package solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author qinghua.shao
 * @date 2024/1/21
 * @since 1.0.0
 */
public class LC0017LetterCombinationsofaPhoneNumber {

    // 数字字母映射Map
    private static Map<Character, String> numLetterMap = new HashMap<Character, String>() {
        {
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }
    };

    private static StringBuilder str = new StringBuilder();

    public static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0) {
            return ans;
        }

        dfs(ans, digits, 0);
        return ans;
    }

    public static void dfs(List<String> ans, String digits, int index) {
        if (index == digits.length()) {
            ans.add(str.toString());
            return;
        } else {
            // 获取指定索引数字对应的字母
            String letters = numLetterMap.get(digits.charAt(index));
            for (int i = 0; i < letters.length(); i++) {
                // 遍历字母追加到之前的组合后
                str.append(letters.charAt(i));
                dfs(ans, digits, index + 1);
                // 删除最后一个
                str.deleteCharAt(index);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
}
