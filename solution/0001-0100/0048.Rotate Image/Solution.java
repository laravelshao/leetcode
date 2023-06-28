class Solution {
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        // 上下翻转
        for (int i = 0; i < length / 2; i++) {
            for (int j = 0; j < length; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[length - i - 1][j];
                matrix[length - i - 1][j] = tmp;
            }
        }
        // 主对角线(/左斜方向)翻转
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
}
