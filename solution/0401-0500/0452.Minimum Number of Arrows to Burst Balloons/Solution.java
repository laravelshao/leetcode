class Solution {
    public int findMinArrowShots(int[][] points) {
        // 按照右坐标升序排列
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] point1, int[] point2) {
                if (point1[1] > point2[1]) {
                    return 1;
                } else if (point1[1] < point2[1]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        // 初始位置：第一箭可以覆盖到的位置，第一个气球的右端点
        int pos = points[0][1];
        int ans = 1;
        for (int[] balloon : points) {
            // 遍历到的气球的左端点大于 pos，说明第一箭覆盖不到
            if (balloon[0] > pos) {
                pos = balloon[1];
                ans++;
            }
        }

        return ans;
    }
}