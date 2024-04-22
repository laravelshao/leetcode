class Solution {
    public int[] plusOne(int[] digits) {

        for(int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            if(digits[i] != 0) {
                return digits;
            }
        }

        // 所有元素都为9，则需要进位，长度+1，设置首位为1，其它默认为0
        int[] ans = new int[digits.length + 1];
        ans[0] = 1;
        return ans;
    }
}