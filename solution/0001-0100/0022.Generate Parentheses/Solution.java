class Solution {
    List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        dfs("", n, n);
        return ans;
    }

    // 关键思路：剩余左括号数要小于右括号数
    // left：剩余左括号数，right：剩余右括号数
    private void dfs(String s, int left, int right) {
        if (left == 0 && right == 0) {
            ans.add(s);
            return;
        }

        // 剩余数量一样，下一个只能用左括号
        if (left == right) {
            dfs(s + "(", left - 1, right);
        } else if (left < right) {
            // 左括号数小于右括号数，下一个可以是左括号或右括号
            if (left > 0) {
                dfs(s + "(", left - 1, right);
            }
            dfs(s + ")", left, right - 1);
        }
    }
}