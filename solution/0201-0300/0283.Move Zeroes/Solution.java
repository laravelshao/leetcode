class Solution {
    public void moveZeroes(int[] nums) {

        // 双指针都指向第一个下标位置
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            // 如果 right 指针位置元素不为0，则交换位置，左右指针都自增；为0则右指针自增
            if (nums[right] != 0) {
                int tmp = nums[right];
                nums[right] = nums[left];
                nums[left] = tmp;
                left++;
            }
            right++;
        }
    }
}