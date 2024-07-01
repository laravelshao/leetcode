class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        // 参考题解：https://leetcode.cn/problems/merge-sorted-array/solutions/13005/hua-jie-suan-fa-88-he-bing-liang-ge-you-xu-shu-zu-/?envType=study-plan-v2&envId=top-interview-150

        // 从后往前遍历，优先填充较大值
        int len1 = m - 1, len2 = n - 1, len = m + n - 1;
        while (len1 >= 0 && len2 >= 0) {
            // 优先填充较大值
            nums1[len--] = nums1[len1] > nums2[len2] ? nums1[len1--] : nums2[len2--];
        }

        // 剩余如果 nums2 还有元素没遍历完需要填充到前面位置
        while (len2 >= 0) {
            nums1[len--] = nums2[len2--];
        }
    }
}