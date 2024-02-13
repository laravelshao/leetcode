class Solution {
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        int m = num1.length(), n = num2.length();
        int[] ans = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            int a = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int b = num2.charAt(j) - '0';
                int sum = ans[i + j + 1] + a * b;
                ans[i + j + 1] = sum % 10;
                // 原始值加上进位值
                ans[i + j] += sum / 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ans.length; i++) {
            // 如果最高位是0则忽略
            if (i == 0 && ans[i] == 0) {
                continue;
            }
            sb.append(ans[i]);
        }

        return sb.toString();
    }
}