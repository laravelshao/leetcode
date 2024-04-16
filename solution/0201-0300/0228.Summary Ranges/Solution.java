class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();

        int i = 0, n = nums.length;
        while (i < n) {
            int low = i;
            i++;
            while (i < n && nums[i] == nums[i - 1] + 1) {
                i++;
            }

            int high = i - 1;

            StringBuilder sb = new StringBuilder(String.valueOf(nums[low]));
            if (low < high) {
                sb.append("->");
                sb.append(String.valueOf(nums[high]));
            }

            ans.add(sb.toString());
        }

        return ans;
    }
}