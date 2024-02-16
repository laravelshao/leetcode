class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return ans;
        }

        // 下标定义
        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;
        // 元素总数
        int elementNum = matrix.length * matrix[0].length;
        while (elementNum > 0) {
            // 左往右遍历
            for (int i = left; i <= right && elementNum > 0; i++) {
                ans.add(matrix[top][i]);
                elementNum--;
            }
            // 将top向下移1位
            top++;

            // 从上往下遍历
            for (int i = top; i <= bottom && elementNum > 0; i++) {
                ans.add(matrix[i][right]);
                elementNum--;
            }
            // 将right往左移一位
            right--;

            // 从右往左遍历
            for (int i = right; i >= left && elementNum > 0; i--) {
                ans.add(matrix[bottom][i]);
                elementNum--;
            }
            // 将bottom往上移一位
            bottom--;

            // 从下往上遍历
            for (int i = bottom; i >= top && elementNum > 0; i--) {
                ans.add(matrix[i][left]);
                elementNum--;
            }
            // 将left向右移动一位
            left++;
        }

        return ans;
    }
}