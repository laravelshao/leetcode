class Solution {
    public int[][] merge(int[][] intervals) {
        // 根据区间起始值升序排列
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int start = intervals[0][0], end = intervals[0][1];
        List<int[]> resultList = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            int tmpStart = intervals[i][0], tmpEnd = intervals[i][1];

            // 没有交集
            if (end < tmpStart) {
                resultList.add(new int[]{start, end});
                start = tmpStart;
                end = tmpEnd;
            } else {
                // 存在交集，则取最大计数值作为 end
                end = Math.max(end, tmpEnd);
            }
        }
        // 将最后一个区间加入
        resultList.add(new int[]{start, end});

        return resultList.toArray(new int[resultList.size()][]);
    }
}