class Solution {
    /**
     * 前缀和 + 二分查找
     */
    public int minSubArrayLen(int target, int[] nums) {
        // length：数组长度
        int length = nums.length;
        // 前缀和数组
        long[] sums = new long[length + 1];
        for (int i = 0; i < length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }

        // minLength：最小长度
        int minLength = length + 1;
        for (int i = 0; i <= length; i++) {
            int j = binarySearch(sums, sums[i] + target);
            if (j <= length) {
                minLength = Math.min(minLength, j - i);
            }
        }

        return minLength <= length ? minLength : 0;
    }

    /**
     * 二分查找
     */
    private int binarySearch(long[] nums, long x) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] >= x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}