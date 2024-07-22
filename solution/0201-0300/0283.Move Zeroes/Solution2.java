class Solution2 {
    public void moveZeroes(int[] nums) {

        int index = 0;
        // 非零往前移
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }

        // 剩余位置填充0
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }
}