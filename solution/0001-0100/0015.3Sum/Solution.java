class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // 升序排列
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        // 遍历第一个数字，因为已经排序，总和等于0，第一个数字肯定小于等于0，且只能遍历到小于n-2，后面需要保留2个数字
        for (int first = 0; first < n - 2 && nums[first] <= 0; first++) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }

            int second = first + 1, third = n - 1;
            while (second < third) {
                int sum = nums[first] + nums[second] + nums[third];
                if (sum < 0) {
                    second++;
                } else if (sum > 0) {
                    third--;
                } else {
                    // 第二个索引需要自增，第三个索引需要自减
                    ans.add(Arrays.asList(nums[first], nums[second++], nums[third--]));
                    // 如果第二个索引位置数字等于自增前索引位置数字，则再自增
                    while (second < third && nums[second] == nums[second - 1]) {
                        second++;
                    }
                    // 如果第三个索引位置数字等于自减前索引位置数字，则再自减；不需要担心超过索引范围，上面已经自减过一次
                    while (second < third && nums[third] == nums[third + 1]) {
                        third--;
                    }
                }
            }
        }

        return ans;
    }
}