class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Map<值, 下标>
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; ; i++) {
            int x = nums[i];
            int y = target - x;
            if (map.containsKey(y)) {
                return new int[]{map.get(y), i};
            }
            map.put(x, i);
        }
    }
}