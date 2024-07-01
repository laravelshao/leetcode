class Solution {
    public int removeElement(int[] nums, int val) {

        // 快慢双指针，fast为快指针每次移动1
        int slow = 0, fast = 0;
        for(; fast < nums.length; fast++) {
            if(nums[fast] != val) {
                nums[slow++] = nums[fast];
            }
        }

        return slow;
    }
}