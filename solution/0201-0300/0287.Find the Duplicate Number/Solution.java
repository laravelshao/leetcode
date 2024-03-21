class Solution {
    public int findDuplicate(int[] nums) {

        // 参考题解：https://leetcode.cn/problems/find-the-duplicate-number/solutions/7038/er-fen-fa-si-lu-ji-dai-ma-python-by-liweiwei1419/

        int len = nums.length;
        // 因为数组长度为len，所以数字范围为[1, len - 1]，所以右指针为 len - 1
        int left = 1, right = len - 1;
        while (left < right) {
            int mid = (left + right) / 2;

            // 遍历数组统计小于等于mid的个数
            int count = 0;
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }

            if (count > mid) {
                // 说明重复数字在区间[left, mid]
                right = mid;
            } else {
                // 说明重复数字在区间[mid + 1, right]
                left = mid + 1;
            }
        }

        return left;
    }
}