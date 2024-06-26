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

    private List<String> ans = new ArrayList<>();

    private StringBuilder str = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return ans;
        }

        dfs(digits, 0);
        return ans;
    }

    public void dfs(String digits, int index) {
        if (index == digits.length()) {
            ans.add(str.toString());
            return;
        }

        // 获取指定索引数字对应的字母
        String letters = numLetterMap.get(digits.charAt(index));
        for (int i = 0; i < letters.length(); i++) {
            // 遍历字母追加到之前的组合后
            str.append(letters.charAt(i));
            dfs(digits, index + 1);
            // 删除最后一个
            str.deleteCharAt(index);
        }
    }
}