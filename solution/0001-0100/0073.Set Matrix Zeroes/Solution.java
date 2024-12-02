/**
 * 原地标记法
 */
class Solution2 {

    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        // 利用第一行、第一列承载，判断第一行第一列是否需要置零
        boolean rowZero = false, columnZero = false;
        for (int j = 0; j < column; j++) {
            if (matrix[0][j] == 0) {
                rowZero = true;
                break;
            }
        }

        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) {
                columnZero = true;
                break;
            }
        }

        // 从第二行第二列开始遍历
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (rowZero) {
            for (int j = 0; j < column; j++) {
                matrix[0][j] = 0;
            }
        }

        if (columnZero) {
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}