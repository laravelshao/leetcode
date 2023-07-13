class Solution {
    public int arrayPairSum(int[] nums) {

        // 先排序
        Arrays.sort(nums);

        // 获取偶数位元素之和就是min最大总和
        int sum = 0;
        for(int i = 0; i < nums.length; i = i+2) {
            sum += nums[i];
        }

        return sum;
    }
}