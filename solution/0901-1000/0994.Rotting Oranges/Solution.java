class Solution {
    public int orangesRotting(int[][] grid) {

        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();

        // 新鲜橘子数量
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    count++;
                } else if (grid[i][j] == 2) {
                    queue.offer(new int[] { i, j });
                }
            }
        }

        // 腐烂轮数(分钟数)
        int round = 0;
        while (count > 0 && !queue.isEmpty()) {
            round++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] orange = queue.poll();
                int x = orange[0], y = orange[1];
                // 坐标(x,y)上下左右新鲜橘子都被腐烂
                // 上边
                if (x - 1 >= 0 && grid[x - 1][y] == 1) {
                    grid[x - 1][y] = 2;
                    count--;
                    queue.offer(new int[] { x - 1, y });
                }
                // 下边
                if (x + 1 < m && grid[x + 1][y] == 1) {
                    grid[x + 1][y] = 2;
                    count--;
                    queue.offer(new int[] { x + 1, y });
                }
                // 左边
                if (y - 1 >= 0 && grid[x][y - 1] == 1) {
                    grid[x][y - 1] = 2;
                    count--;
                    queue.offer(new int[] { x, y - 1 });
                }
                // 右边
                if (y + 1 < n && grid[x][y + 1] == 1) {
                    grid[x][y + 1] = 2;
                    count--;
                    queue.offer(new int[] { x, y + 1 });
                }
            }
        }

        return count > 0 ? -1 : round;
    }
}