class Solution {
    public int[][] generateMatrix(int n) {

        int[][] ans = new int[n][n];

        // 下标定义
        int top = 0, bottom = n - 1;
        int left = 0, right = n - 1;
        // 元素总数
        int num = 1, target = n * n;
        while (num <= target) {
            // 左往右遍历
            for (int i = left; i <= right; i++) {
                ans[top][i] = num++;
            }
            // 将top向下移1位
            top++;

            // 从上往下遍历
            for (int i = top; i <= bottom; i++) {
                ans[i][right] = num++;
            }
            // 将right往左移一位
            right--;

            // 从右往左遍历
            for (int i = right; i >= left; i--) {
                ans[bottom][i] = num++;
            }
            // 将bottom往上移一位
            bottom--;

            // 从下往上遍历
            for (int i = bottom; i >= top; i--) {
                ans[i][left] = num++;
            }
            // 将left向右移动一位
            left++;
        }

        return ans;
    }
}