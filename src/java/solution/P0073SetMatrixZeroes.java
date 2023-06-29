package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 73.Set Matrix Zeroes
 *
 * @author qinghua.shao
 * @date 2023/6/29
 * @since 1.0.0
 */
class P0073SetMatrixZeroes {

    /**
     * 数组标记法
     *
     * @param matrix 数组
     */
    public static void setZeroes(int[][] matrix) {
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

    /**
     * 原地标记法
     *
     * @param matrix 数组
     */
    public static void setZeroes2(int[][] matrix) {
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

    public static void main(String[] args) {

        int[][] matrix1 = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        setZeroes(matrix1);
        System.out.println(Arrays.deepToString(matrix1));

        int[][] matrix2 = new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        setZeroes(matrix2);
        System.out.println(Arrays.deepToString(matrix2));

        System.out.println("=====================================");

        int[][] matrix3 = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        setZeroes2(matrix3);
        System.out.println(Arrays.deepToString(matrix3));

        int[][] matrix4 = new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        setZeroes2(matrix4);
        System.out.println(Arrays.deepToString(matrix4));

    }
}