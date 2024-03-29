class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
            
        // 参考题解：https://leetcode.cn/problems/merge-sorted-array/solutions/13005/hua-jie-suan-fa-88-he-bing-liang-ge-you-xu-shu-zu-/?envType=study-plan-v2&envId=top-interview-150

        // len1：nums1最大下标 len2：nums2最大下标 len：总长度下标
        int len1 = m - 1, len2 = n - 1, len = m + n - 1;
        // 两个数组都没遍历完
        while (len1 >= 0 && len2 >= 0) {
            // 优先填充较大值
            nums1[len--] = nums1[len1] > nums2[len2] ? nums1[len1--] : nums2[len2--];
        }

        // m > n：数组 nums1 元素个数大于数组 nums2 元素个数，则无需处理
        // m < n：数组 nums1 元素个数小于数组 nums2 元素个数，数组 nums2 剩余元素需要填充到 nums1 前部
        while (len2 >= 0) {
            nums1[len--] = nums2[len2--];
        }
    }
}