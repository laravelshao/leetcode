class Solution {
    public int maxProduct(int[] nums) {

        long maxF = nums[0], minF = nums[0];
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            long mx = maxF, mn = minF;
            maxF = Math.max(nums[i], Math.max(mx * nums[i], mn * nums[i]));
            minF = Math.min(nums[i], Math.min(mx * nums[i], mn * nums[i]));
            if(minF < Integer.MIN_VALUE) {
                minF = nums[i];
            }
            ans = Math.max((int)maxF, ans);
        }

        return ans;
    }
}