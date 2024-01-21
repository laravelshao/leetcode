class Solution {
    public int maxArea(int[] height) {

        // 初始最大容量为0
        int max = 0;
        // 双指针，初始left指向idx=0，右指针指向idx=length-1
        int left = 0, right = height.length - 1;
        while (left < right) {
            int volume = (right - left) * Math.min(height[left], height[right]);
            max = Math.max(max, volume);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }
}