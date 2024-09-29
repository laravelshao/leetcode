class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                right = mid; // 最小值在[left, mid]
            } else {
                left = mid + 1; // 最小值在[mid + 1, right]
            }
        }

        return nums[left];
    }
}