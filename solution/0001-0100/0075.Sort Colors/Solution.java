class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int p0 = 0, p2 = n - 1;
        for(int i = 0; i <= p2; i++) {
            // 交换后 nums[i] 可能还是 2，所以需要一直交换
            while (i <= p2 && nums[i] == 2) {
                swap(nums, i, p2);
                p2--;
            }

            if(nums[i] == 0) {
                swap(nums, i, p0);
                p0++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}