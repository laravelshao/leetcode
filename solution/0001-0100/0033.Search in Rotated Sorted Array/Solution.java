class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;
        // 思路：二分查找，将数组分割成[left,.. mid]，[mid + 1,.. right]两部分，这时候可以发现，其中有一部分一定是有序的。
        // 因此，我们可以根据有序的那一部分，判断 target 是否在这一部分中：
        // 1.若[0,.. mid]范围内的元素构成升序数组：
        // - 若满足 nums[0] <= target <= nums[mid]，那么我们搜索范围可以缩小为[left,.. mid]；
        // - 否则，在[mid + 1,.. right]中查找；
        // 2.若[mid + 1, n - 1]范围内的元素构成升序数组：
        // - 若满足 nums[mid] < target <= nums[n - 1]，那么我们搜索范围可以缩小为[mid + 1,.. right]；
        // - 否则，在[left,.. mid]中查找。
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[0] <= nums[mid]) {
                // 前半段升序
                if (nums[0] <= target && target <= nums[mid]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            } else {
                // 后半段升序
                if (nums[mid] < target && target <= nums[n - 1]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
        }

        return nums[left] == target ? left : -1;
    }
}