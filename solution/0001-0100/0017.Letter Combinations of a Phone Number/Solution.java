class Solution {

    // 数字字母映射Map
    Map<Character, String> numLetterMap = new HashMap<>() {
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

    private StringBuilder str = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0) {
            return ans;
        }

        dfs(ans, digits, 0);
        return ans;
    }

    public void dfs(List<String> ans, String digits, int index) {
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
}