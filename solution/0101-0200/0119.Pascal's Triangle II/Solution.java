class Solution {
    public List<Integer> getRow(int rowIndex) {

        // 行结果列表
        List<Integer> rowList = new ArrayList<>();

        // 创建一个长度为 rowIndex + 1 的数组 rowList，初始时所有元素均为 1
        for (int i = 0; i < rowIndex + 1; ++i) {
            rowList.add(1);
        }

        //第 2 行开始，从后往前计算当前行的第 j 个元素的值 rowList[j] = rowList[j] + rowList[j - 1]
        for (int i = 2; i < rowIndex + 1; ++i) {
            for (int j = i - 1; j > 0; --j) {
                rowList.set(j, rowList.get(j) + rowList.get(j - 1));
            }
        }
        return rowList;
    }
}