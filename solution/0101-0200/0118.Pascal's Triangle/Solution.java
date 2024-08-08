class Solution {
    public List<List<Integer>> generate(int numRows) {

        // 转移方程：dp(i, j) = dp(i - 1, j - 1) + dp(i - 1, j)
        // 初始状态：每行首尾都是1
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for(int j = 0; j <= i; j++) {
                // 每行首尾默认添加1
                if(j == 0 || j == i) {
                    row.add(1);
                } else {
                    // 非行首行尾 dp(i, j) = dp(i - 1, j - 1) + dp(i - 1, j)
                    row.add(ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j));
                }
            }
            ans.add(row);
        }

        return ans;
    }
}