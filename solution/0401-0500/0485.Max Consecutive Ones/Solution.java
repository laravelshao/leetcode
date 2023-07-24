class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {

        // maxCount：最大连续计数 tmpCount：当前连续计数
        int maxCount = 0, tmpCount = 0;
        for (int num : nums) {
            if (num == 1) {
                tmpCount++;
            } else {
                maxCount = Math.max(maxCount, tmpCount);
                tmpCount = 0;
            }
        }
        return Math.max(maxCount, tmpCount);
    }
}