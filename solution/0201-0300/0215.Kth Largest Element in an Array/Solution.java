class Solution {
    public int findKthLargest(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        return quickSelect(list, k);
    }

    private int quickSelect(List<Integer> nums, int k) {
        Random random = new Random();
        // 随机选择基准值
        int base = nums.get(random.nextInt(nums.size()));
        List<Integer> small = new ArrayList<>();
        List<Integer> big = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();

        // 将大于、小于、等于的元素添加到指定的列表中
        for (int num : nums) {
            if (num > base) {
                big.add(num);
            } else if (num < base) {
                small.add(num);
            } else {
                equal.add(num);
            }
        }

        // 第 k 个最大元素在 big 列表中
        if (k <= big.size()) {
            return quickSelect(big, k);
        }

        // 第 k 个最大元素在 small 列表中
        if (k > nums.size() - small.size()) {
            return quickSelect(small, k - (nums.size() - small.size()));
        }

        // 第 k 个最大元素在 equal 列表中
        return base;
    }
}