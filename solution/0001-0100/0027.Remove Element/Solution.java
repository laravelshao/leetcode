class Solution {
    public int removeElement(int[] nums, int val) {

        // fast为快指针，每次移动1
        int fast = 0, slow = 0;
        for (; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
}