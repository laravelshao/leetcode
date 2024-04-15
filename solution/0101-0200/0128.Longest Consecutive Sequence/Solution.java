class Solution {
    public int longestConsecutive(int[] nums) {
        
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }

        int ans = 0;
        for(int num : nums) {
            // 避免多余重复的判断，当前数没有前驱数 num - 1，如果存在那么最长子序列肯定会从 num - 1 开始，那样长度更长
            if(!set.contains(num - 1)) {
                int tmpNum = num, tmpLen = 0;
                while(set.contains(tmpNum)) {
                    tmpLen++;
                    tmpNum++;
                }
                ans = Math.max(ans, tmpLen);
            }
        }

        return ans;
    }
}