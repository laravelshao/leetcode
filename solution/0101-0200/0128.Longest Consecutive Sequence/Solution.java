class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }

        int ans = 0;
        for(int num : nums) {
            // 避免多余重复的判断，如果当前数没有前驱数 num - 1，那就从当前数开始重新统计
            if(!set.contains(num - 1)) {
                int tmpNum = num, tmpLen = 0;
                while (set.contains(tmpNum)) {
                    tmpNum++;
                    tmpLen++;
                }
                ans = Math.max(ans, tmpLen);
            }
        }

        return ans;
    }
}