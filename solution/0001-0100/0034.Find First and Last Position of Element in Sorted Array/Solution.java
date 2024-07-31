class Solution {
    public int[] searchRange(int[] nums, int target) {

        // 寻找左边界(寻找第一个 >= target 的索引)
        int left = search(nums, target);
        if (left == nums.length || nums[left] != target) {
            return new int[] { -1, -1 };
        }

        // 寻找右边界(寻找第一个 >= target + 1 的索引)
        int right = search(nums, target + 1) - 1;
        return new int[] { left, right };
    }

    private int search(int[] nums, int x) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}