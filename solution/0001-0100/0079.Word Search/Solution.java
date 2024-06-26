class Solution {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * k：当前目标字符在 word 中的索引
     */
    private boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        // 行列索引越界 || 当前索引位置元素与目标字符不同
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) {
            return false;
        }
        // 字符串已经全部匹配
        if (k == word.length - 1) {
            return true;
        }

        // 标记当前下标元素，将字符串修改为空字符串，代表此元素已访问过，防止之后搜索时重复访问
        board[i][j] = '\0';
        // 递归判断上下左右方向是否支持，只要有一个方向满足，就满足
        boolean res = dfs(board, word, i - 1, j, k + 1) || dfs(board, word, i + 1, j, k + 1)
                || dfs(board, word, i, j - 1, k + 1) || dfs(board, word, i, j + 1, k + 1);
        board[i][j] = word[k];
        return res;
    }
}