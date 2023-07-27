class Solution {
    public int findMin(int[] nums) {

        int len = nums.length;
        if (nums[0] <= nums[len - 1]) {
            return nums[0];
        }

        int left = 0, right = len - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[0] <= nums[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }
}