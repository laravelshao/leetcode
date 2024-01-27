class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return ans;
        }

        // 先升序排序处理
        Arrays.sort(nums);
        int n = nums.length;
        // 第一层循环固定第一个数字
        for (int first = 0; first < n - 3; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // 第二层循环固定第二个数字
            for (int second = first + 1; second < n - 2; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }

                // 第三层循环，双指针
                // 第三个起始位置指向第二个+1，第四个起始位置指向数字最后一个元素
                int third = second + 1, fourth = n - 1;
                while (third < fourth) {
                    long tmpSum = (long) nums[first] + nums[second] + nums[third] + nums[fourth];
                    if (tmpSum > target) {
                        fourth--;
                    } else if (tmpSum < target) {
                        third++;
                    } else {
                        ans.add(Arrays.asList(nums[first], nums[second], nums[third++], nums[fourth--]));
                        // 如果相邻数组相同，则一直自增
                        while (third < fourth && nums[third] == nums[third - 1]) {
                            third++;
                        }
                        // 如果相邻数组相同，则一直自减
                        while (third < fourth && nums[fourth] == nums[fourth + 1]) {
                            fourth--;
                        }
                    }
                }
            }
        }

        return ans;
    }
}