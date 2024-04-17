class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        // 新插入区间左右范围值
        int left = newInterval[0], right = newInterval[1];
        List<int[]> ans = new ArrayList<>();
        boolean placed = false;
        for (int[] interval : intervals) {
            // 不存在交集有2种情况：
            if (interval[1] < left) {
                // 当前区间结束值小于新插入区间的起始值
                ans.add(interval);
            } else if (interval[0] > right) {
                // 当前区间起始值大于新插入区间的结束值
                if (!placed) {
                    ans.add(new int[] { left, right});
                    placed = true;
                }
                ans.add(interval);
            } else {
                // 存在交集
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }

        if (!placed) {
            ans.add(new int[] { left, right });
        }

        return ans.toArray(new int[ans.size()][]);
    }
}