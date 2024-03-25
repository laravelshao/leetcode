class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 将矩阵看为以右上角为根节点的二叉树
        int i = matrix.length - 1, j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] > target) {
                i--;
            } else if (matrix[i][j] < target) {
                j++;
            } else {
                return true;
            }
        }

        return false;
    }
}