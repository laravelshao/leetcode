class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 构造邻接表
        List<List<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        for (int[] cp : prerequisites) {
            adjacency.get(cp[1]).add(cp[0]);
        }

        // flags：表示每个课程 i 状态
        // 1、未被 DFS 访问：i == 0
        // 2、已被其他节点启动的 DFS 访问：i == -1
        // 3、已被当前节点启动的 DFS 访问：i == 1
        int[] flags = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(adjacency, flags, i)) {
                return false;
            }
        }

        return true;
    }

    // 判断是否存在环，存在返回 false，否则返回 true
    private boolean dfs(List<List<Integer>> adjacency, int[] flags, int i) {
        if (flags[i] == 1) {
            return false;
        }
        if (flags[i] == -1) {
            return true;
        }

        flags[i] = 1;
        for (Integer j : adjacency.get(i)) {
            if (!dfs(adjacency, flags, j)) {
                return false;
            }
        }

        flags[i] = -1;
        return true;
    }
}