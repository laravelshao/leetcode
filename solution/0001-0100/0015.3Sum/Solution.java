class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // 升序排列
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        // 思路先固定三数最小值 nums[k]，然后双指针在剩余区间两端
        for (int k = 0; k < nums.length - 2; k++) {
            // 如果最小数都大于0，三数之和肯定大于0不符合条件
            if (nums[k] > 0) {
                break;
            }
            // 和上一次固定的最小值相同，直接跳过
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }

            // 初始化双指针指向剩余两端
            int i = k + 1, j = nums.length - 1;
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum > 0) {
                    j--;
                } else if (sum < 0) {
                    i++;
                } else {
                    // 注意后自增
                    res.add(Arrays.asList(nums[k], nums[i++], nums[j--]));
                    // 如果第二个索引自增后位置与前一位置数字相同，则再自增
                    while (i < j && nums[i] == nums[i - 1]) {
                        i++;
                    }
                    // 如果第三个索引自减后位置与后一位置数字相同，则再自减
                    while (i < j && nums[j] == nums[j + 1]) {
                        j--;
                    }
                }
            }
        }

        return res;
    }
}