class Solution {
    public String addStrings(String num1, String num2) {

        StringBuilder res = new StringBuilder();
        // 从后往前遍历，依次取指定索引位置数字相加，进位初始化为0
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        while (i >= 0|| j >= 0) {
            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int tmp = n1 + n2 + carry;
            carry = tmp / 10;
            res.append(tmp % 10);
            i--;
            j--;
        }

        // 最后剩余如果有进位
        if(carry > 0) {
            res.append(carry);
        }

        return res.reverse().toString();
    }
}