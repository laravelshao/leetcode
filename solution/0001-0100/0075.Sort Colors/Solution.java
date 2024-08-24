class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        // p0：指向0的开始下标，每次有数字0时交换到该位置，且自增1
        // p2：指向2的开始下标，每次有数字2时交换到该下标，且自减1
        int p0 = 0, p2 = n - 1;
        for (int i = 0; i <= p2; i++) {
            // 交换后 nums[i] 可能还是 2，所以需要一直交换
            while (i <= p2 && nums[i] == 2) {
                swap(nums, i, p2);
                p2--;
            }

            if (nums[i] == 0) {
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