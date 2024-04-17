class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m * n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int tmp = matrix[mid / n][mid % n];
            if (tmp < target) {
                left = mid + 1;
            } else if (tmp > target) {
                right = mid - 1;
            } else {
                return true;
            }
        }

        return false;
    }
}