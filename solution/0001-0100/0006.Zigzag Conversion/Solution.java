class Solution {
    public String convert(String s, int numRows) {
        // 仅有1行原样输出
        if (numRows < 2) {
            return s;
        }

        // 初始化每行数据
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }

        // i：行号，从0 -> numRows-1 -> 0...
        int i = 0, flag = -1;
        for (char c : s.toCharArray()) {
            // 附加到指定行字符串末尾
            rows.get(i).append(c);
            // 到第一行或最后一行取反flag
            if (i == 0 || i == numRows - 1) {
                flag = -flag;
            }
            i += flag;
        }

        StringBuilder res = new StringBuilder();
        for(StringBuilder row : rows) {
            res.append(row);
        }

        return res.toString();
    }
}