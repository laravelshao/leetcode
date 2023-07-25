class Solution {
    public List<List<Integer>> generate(int numRows) {

        // 结果列表
        List<List<Integer>> result = new ArrayList<>(numRows);
        // 填充第一行
        result.add(Arrays.asList(1));
        for (int i = 0; i < numRows - 1; i++) {
            List<Integer> tmpList = new ArrayList<>();
            // 头部填1
            tmpList.add(1);
            // 第2行，j<0，不满足
            // 第3行，j<1，执行1次循环，添加元素2
            for (int j = 0; j < result.get(i).size() - 1; j++) {
                tmpList.add(result.get(i).get(j) + result.get(i).get(j + 1));
            }
            // 尾部填1
            tmpList.add(1);
            result.add(tmpList);
        }

        return result;
    }
}