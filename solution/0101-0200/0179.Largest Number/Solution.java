class Solution {
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }

        // 从大到小排列
        Arrays.sort(strs, (x, y) -> (y + x).compareTo(x + y));
        // 说明全部都是0
        if (strs[0].equals("0")) {
            return "0";
        }

        StringBuilder res = new StringBuilder();
        for (String str : strs) {
            res.append(str);
        }

        return res.toString();
    }
}