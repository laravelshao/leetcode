class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        // 定义两种新状态：
        // 2：代表活细胞在下一状态为死细胞
        // -1：代表死细胞在下一状态转为活细胞
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 统计当前位置周围(3*3范围)活细胞数
                int live = -board[i][j];
                for (int x = i - 1; x <= i + 1; x++) {
                    for (int y = j - 1; y <= j + 1; y++) {
                        if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] > 0) {
                            live++;
                        }
                    }
                }

                // 活细胞 转 死细胞
                if (board[i][j] == 1 && (live < 2 || live > 3)) {
                    board[i][j] = 2;
                }
                // 死细胞 转 活细胞
                if (board[i][j] == 0 && live == 3) {
                    board[i][j] = -1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                } else if (board[i][j] == -1) {
                    board[i][j] = 1;
                }
            }
        }
    }
}