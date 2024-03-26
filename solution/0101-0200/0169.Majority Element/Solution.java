class Solution {
    public int majorityElement(int[] nums) {
        // x：众数，初始设置为0 votes：投票和，众数+1，非众数-1
        int x = 0, votes = 0; 
        for(int num : nums) {
            // 投票为0则将当前数假定为众数，因为前面一半是众数一半不是
            // 剩余元素中的众数还是整个数组的众数
            if(votes == 0) {
                x = num;
            }

            if(num == x) {
                votes++;
            } else {
                votes--;
            }
        }

        return x;
    }
}