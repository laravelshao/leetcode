package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Merge Intervals
 *
 * @author qinghua.shao
 * @date 2023/6/27
 * @since 1.0.0
 */
public class P0056MergeIntervals {

    public static int[][] merge(int[][] intervals) {
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

    public static void main(String[] args) {

        int[][] merge1 = merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
        System.out.println(Arrays.deepToString(merge1));

        int[][] merge2 = merge(new int[][]{{1, 4}, {4, 5}});
        System.out.println(Arrays.deepToString(merge2));
    }
}
