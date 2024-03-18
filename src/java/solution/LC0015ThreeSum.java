package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author qinghua.shao
 * @date 2024/1/21
 * @since 1.0.0
 */
public class LC0015ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        // 升序排列
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        // 遍历第一个数字，因为已经排序，总和等于0，第一个数字肯定是负数，且只能遍历到小于n-2，后面需要保留2个数字
        for (int first = 0; first < n - 2 && nums[first] <= 0; first++) {
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
                    ans.add(Arrays.asList(nums[first], nums[second++], nums[third--]));
                    while (second < third && nums[second] == nums[second + 1]) {
                        second++;
                    }
                    while (second < third && nums[third] == nums[third - 1]) {
                        third--;
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{0,0,0}));;
    }
}
