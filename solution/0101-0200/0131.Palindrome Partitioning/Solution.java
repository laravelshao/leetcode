class Solution {

    private List<List<String>> ans = new ArrayList<>();

    private List<String> path = new ArrayList<>();

    public List<List<String>> partition(String s) {
        dfs(s, 0);
        return ans;
    }

    private void dfs(String s, int index) {
        if (index == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for(int j = index; j < s.length(); j++) {
            if(isPalindrome(s, index, j)) {
                // 做出选择
                path.add(s.substring(index, j + 1));
                // 递归调用
                dfs(s, j + 1);
                // 回退选择
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}