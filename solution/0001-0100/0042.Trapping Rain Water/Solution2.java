class Solution2 {
    public int trap(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int n = height.length;

        // 设置2个数组，分别从左从右计算每个下标位置最大能接到的雨水数
        // 最终能接收到雨水数：min(leftMax[i], rightMax[i]) - height[i]
        int[] leftMax = new int[n], rightMax = new int[n];
        leftMax[0] = height[0];
        rightMax[n - 1] = height[n - 1];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return ans;
    }
}