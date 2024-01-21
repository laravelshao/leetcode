class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // 升序排列
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 1 << 30;
        for (int first = 0; first < n; first++) {
            int second = first + 1, third = n - 1;
            while (second < third) {
                int sum = nums[first] + nums[second] + nums[third];
                if (sum == target) {
                    return sum;
                }
                // 如果此时遍历的总和小于之前的总和，则覆盖
                if (Math.abs(sum - target) < Math.abs(ans - target)) {
                    ans = sum;
                }
                // 如果总和大于目标值，则指针三自减，否则指针二自增
                if (sum > target) {
                    third--;
                } else {
                    second++;
                }
            }
        }
        return ans;
    }
}