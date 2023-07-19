class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int length = numbers.length;
        for (int i = 0, j = length - 1; ; ) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[]{i + 1, j + 1};
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
    }
}