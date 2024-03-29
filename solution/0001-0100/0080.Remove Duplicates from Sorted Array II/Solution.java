class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 2) {
            return nums.length;
        }
        // fast：快指针，每次移动1
        int fast = 2, slow = 2;
        for(; fast < nums.length; fast++) {
            // slow - 1 为上一个保留元素
            // 要求相同元素出现2次，所以 上上元素下标为 slow - 2
            if(nums[fast] != nums[slow - 2]) {
                nums[slow++] = nums[fast];
            }
        }

        return slow;
    }
}