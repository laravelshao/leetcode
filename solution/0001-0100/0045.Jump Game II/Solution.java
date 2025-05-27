class Solution {
    public int jump(int[] nums) {
        // steps：跳跃次数 end：下一次跳跃覆盖的最远距离 maxDistance：最大距离
        int steps = 0, end = 0, maxDistance = 0;
        // 不需要遍历到最后一个元素，因为我们在遍历最后一个元素前，已经能够覆盖到最后位置，无需额外增加跳跃次数
        for (int i = 0; i < nums.length - 1; i++) {
            // 获取当前这一步能够达到的最大距离
            maxDistance = Math.max(maxDistance, i + nums[i]);
            // 遇到边界就更新边界，并且步数加一
            if (i == end) {
                steps++;
                end = maxDistance;
            }
        }

        return steps;
    }
}