class Solution {
    public int hIndex(int[] citations) {
        // 升序排列
        Arrays.sort(citations);
        int h = 0, i = citations.length - 1;
        // 降序判断索引位置值是否大于 h，如果大于则 h++
        // 指定下标值大于 h，已经遍历过的值比下标值大，一定是大于当前 h 值
        while (i >= 0 && citations[i] > h) {
            h++;
            i--;
        }

        return h;
    }
}