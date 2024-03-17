class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // 设置双指针，left从头开始，right从尾部开始
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[] { left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[2];
    }
}