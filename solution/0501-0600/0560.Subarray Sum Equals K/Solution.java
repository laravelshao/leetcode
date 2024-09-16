class Solution {
    public int subarraySum(int[] nums, int k) {

        // key：前缀和 value：前缀和的个数
        Map<Integer, Integer> preSumCountMap = new HashMap<>();
        // 对于下标为 0 的元素，前缀和为 0，个数为 1
        // 当 preSum - k = 0 时，count 需要加 1
        preSumCountMap.put(0, 1);

        int ans = 0, preSum = 0;
        for (int num : nums) {
            preSum += num;
            // preSum - (preSum - k) = k
            // 计数加上 preSum - k 的个数
            ans += preSumCountMap.getOrDefault(preSum - k, 0);
            preSumCountMap.put(preSum, preSumCountMap.getOrDefault(preSum, 0) + 1);
        }
        return ans;
    }
}