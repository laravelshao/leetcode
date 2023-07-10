package solution.part01;

import java.util.Arrays;

/**
 * 48.Rotate Image
 *
 * @author qinghua.shao
 * @date 2023/6/28
 * @since 1.0.0
 */
public class P0048RotateImage {

    public static void rotate(int[][] matrix) {
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

    public static void main(String[] args) {

            int[][] matrix1 = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
            rotate(matrix1);
            System.out.println(Arrays.deepToString(matrix1));

            int[][] matrix2 = new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
            rotate(matrix2);
            System.out.println(Arrays.deepToString(matrix2));
    }
}
