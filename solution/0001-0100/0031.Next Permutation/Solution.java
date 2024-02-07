class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;
        // 1.我们需要将一个左边的「较小数」与一个右边的「较大数」交换，以能够让当前排列变大，从而得到下一个排列。
        // 2.同时我们要让这个「较小数」尽量靠右，而「较大数」尽可能小。当交换完成后，「较大数」右边的数需要按照升序重新排列。
        // 这样可以在保证新排列大于原来排列的情况下，使变大的幅度尽可能小。

        // 第一次遍历：从后往前遍历找一个较小数，升序位置；满足nums[i] < nums[i+1]的位置。而从区间[i+1, n-1]是降序排列的。
        for (; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                break;
            }
        }

        // 第二次遍历：从后往前遍历找较大数，不能超过i位置，满足nums[j] > nums[i]
        if (i >= 0) {
            for (int j = n - 1; j > i; j--) {
                if (nums[j] > nums[i]) {
                    swap(nums, i, j);
                    break;
                }
            }
        }

        // 将剩余的[i+1, n-1]降序区间元素升序排列
        for (int j = i + 1, k = n - 1; j < k; j++, k--) {
            swap(nums, j, k);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}