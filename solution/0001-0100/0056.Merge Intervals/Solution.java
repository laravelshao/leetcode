class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int start = intervals[0][0], end = intervals[0][1];
        List<int[]> resultList = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            int tmpStart = intervals[i][0], tmpEnd = intervals[i][1];
            if (end < tmpStart) {
                resultList.add(new int[]{start, end});
                start = tmpStart;
                end = tmpEnd;
            } else {
                end = Math.max(end, tmpEnd);
            }
        }
        resultList.add(new int[]{start, end});

        return resultList.toArray(new int[resultList.size()][]);
    }
}