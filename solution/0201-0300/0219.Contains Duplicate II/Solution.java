class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer, Integer> numIdxMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (numIdxMap.containsKey(num) && i - numIdxMap.get(num) <= k) {
                return true;
            }

            numIdxMap.put(nums[i], i);
        }

        return false;
    }
}