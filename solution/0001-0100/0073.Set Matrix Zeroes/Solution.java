/**
 * 数组标记法
 */
class Solution {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        // 行零值下标列表
        List<Integer> rowZeroIndexList = new ArrayList<>();
        // 列零值下标列表
        List<Integer> columnZeroIndexList = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == 0) {
                    rowZeroIndexList.add(i);
                    columnZeroIndexList.add(j);
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (rowZeroIndexList.contains(i) || columnZeroIndexList.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}