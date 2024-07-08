class Solution {
    public boolean canJump(int[] nums) {
        // max：代表能够到达的最远下标
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            // 最远下标小于当前位置说明不可达
            if (max < i) {
                return false;
            }
            max = Math.max(max, i + nums[i]);
        }
        return true;
    }
}