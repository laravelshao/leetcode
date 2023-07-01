class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        // 遍历对角线次数
        int count = n + m - 1;
        // 结果数组
        int[] reslut = new int[n * m];
        for(int i = 0, idx = 0; i < count; i++) {
            // 偶数(0/2/4/6)从左下往右上遍历，奇数(1/3/5)从右上往左下遍历
            // 且每条对角线每个元素行列索引和等于遍历的索引下标
            if(i % 2 == 0) {
                // 偶数，需要注意右下元素的起始不能超过行数
                for(int j = Math.min(i, n - 1); j >= Math.max(0,  i - m + 1); j--) {
                    reslut[idx++] = mat[j][i-j];
                }
            } else {
                // 奇数，需要注意右下元素的
                for(int j = Math.max(0, i - m + 1); j <= Math.min(i,n -1); j++) {
                    reslut[idx++] = mat[j][i-j];
                }
            } 
        }

        return reslut;
    }
}