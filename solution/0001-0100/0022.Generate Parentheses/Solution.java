class Solution {

    private List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        dfs("", n, n);
        return ans;
    }

    /**
     * left：剩余可用左括号数 right：left：剩余可用右括号数
     */
    private void dfs(String s, int left, int right) {
        if(left == 0 && right == 0) {
            ans.add(s);
            return;
        }

        // 剪枝：有效组合的剩余左括号数一定小于剩余右括号数，所以如果 left > right 肯定不合法
        if(left > right) {
            return;
        }

        if(left > 0) {
            dfs(s + "(", left - 1, right);
        }

        if(right > 0) {
            dfs(s + ")", left, right - 1);
        }
    }
}