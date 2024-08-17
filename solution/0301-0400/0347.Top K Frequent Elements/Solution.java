class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // 统计每个数字数量
        Map<Integer, Integer> numCntMap = new HashMap<>();
        for (int num : nums) {
            numCntMap.put(num, numCntMap.getOrDefault(num, 0) + 1);
        }

        List<int[]> numCnt = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : numCntMap.entrySet()) {
            numCnt.add(new int[] { entry.getKey(), entry.getValue() });
        }

        // 快速排序
        List<int[]> topKs = findTopK(numCnt, k, 0, numCnt.size() - 1);
        int[] ans = new int[k];
        for(int i = 0; i < k; i++) {
            ans[i] = topKs.get(i)[0];
        }
        return ans;
    }

    private List<int[]> findTopK(List<int[]> numCnt, int k, int start, int end) {
        // 随机选择一个数作为基准数，并将其挪至最左侧
        int pivotIdx = (int)(Math.random() * (end - start + 1)) + start;
        Collections.swap(numCnt, pivotIdx, start);

        // 基准数
        int pivot = numCnt.get(start)[1];
        int index = start;
        // 从第二个元素开始遍历，比基准数大的挪至左边，比基准数小的挪至右边
        for (int i = start + 1; i <= end; i++) {
            if(numCnt.get(i)[1] > pivot) {
                // 遍历到元素大于基准数则交换位置
                Collections.swap(numCnt, index + 1, i);
                // 并将索引后移1位
                index++;
            }
        }
        // 将排序后比基准值大的最后一个元素与基准值交换位置，在 index 之前都是比基准值大，之后都是比基准值小
        Collections.swap(numCnt, start, index);

        if(index == k - 1) {
            return numCnt.subList(0, k);
        } else if(index > k - 1) {
            // index 及之前的元素组成了top(K+N)，需要从top(K+N)中选出top(K)
            return findTopK(numCnt, k, start, index - 1);
        } else {
            // index 及之前的元素组成了top(K-N)，要从 index 之后元素中选出top(N)
            return findTopK(numCnt, k, index + 1, end);
        }
    }
}