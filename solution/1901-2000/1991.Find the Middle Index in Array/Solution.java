class Solution {
    public int findMiddleIndex(int[] nums) {
        int n = nums.length, sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        int leftSum = 0, rightSum = sum;
        for (int i = 0; i < n; i++) {
            rightSum -= nums[i];
            if(leftSum == rightSum) {
                return i;
            }
            leftSum += nums[i];
        }

        return -1;
    }
}