class Solution {
    public int numIslands(char[][] grid) {
        int ans = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                // 当节点是陆地'1'时开始dfs
                if(grid[i][j] == '1') {
                    dfs(grid, i, j);
                    ans++;
                }
            }
        }

        return ans;
    }

    private void dfs(char[][] grid, int i, int j) {
        // 上下左右查询可能会越界
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        // 遍历完之后将其置为'0'，防止后续再被遍历到
        grid[i][j] = '0';
        // 针对当前位置的上下左右进行进行深度遍历
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
}