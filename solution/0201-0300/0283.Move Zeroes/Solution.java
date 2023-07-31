class Solution {
    public void moveZeroes(int[] nums) {

        // 双指针
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            // 如果 right 指针位置元素不为0，则交换位置
            if (nums[right] != 0) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left++;
            }
            right++;
        }
    }
}