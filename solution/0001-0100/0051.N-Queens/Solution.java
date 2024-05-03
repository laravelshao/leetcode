class Solution {

    private List<List<String>> ans = new ArrayList<>();

    private int n;

    // 选择状态
    private int[] state;
    
    // cols：标记列是否有皇后 diags1：标记主对角线(\)是否有皇后 diags2：标记次对角线(/)是否有皇后
    boolean[] cols, diags1, diags2;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        state = new int[n];
        cols = new boolean[n];
        diags1 = new boolean[2 * n - 1];
        diags2 = new boolean[2 * n - 1];

        dfs(n, 0);
        return ans;
    }

    private void dfs(int n, int row) {
        // 是否为解
        if(row == n) {
            // 记录结果
            List<String> board = new ArrayList<>();
            for(int c : state) {
                char[] cs = new char[n];
                Arrays.fill(cs, '.');
                cs[c] = 'Q';
                board.add(new String(cs));
            }
            ans.add(board);
            return;
        }

        for(int col = 0; col < n; col++) {
            // 计算主对角线和次对角线下标
            int diag1 = row - col + n - 1;
            int diag2 = row + col;
            // 剪枝：不允许格子所在列、主对角线、次对角线存在皇后
            if(!cols[col] && !diags1[diag1] && !diags2[diag2]) {
                // 做出选择
                state[row] = col;
                cols[col] = diags1[diag1] = diags2[diag2] = true;
                // 递归调用
                dfs(n, row + 1);
                // 回退选择
                cols[col] = diags1[diag1] = diags2[diag2] = false;
            }
        } 
    }
}