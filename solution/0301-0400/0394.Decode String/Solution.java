class Solution {
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        // 承载左括号前的数字的栈
        LinkedList<Integer> stack_multi = new LinkedList<>();
        // 承载结果的栈
        LinkedList<String> stack_res = new LinkedList<>();

        for(char c : s.toCharArray()) {
            if(c == '[') {
                stack_multi.addLast(multi);
                stack_res.addLast(res.toString());
                // 将 multi、res 重置
                multi = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                StringBuilder tmp = new StringBuilder();
                int cur_multi = stack_multi.removeLast();
                for(int i = 0; i < cur_multi; i++) {
                    tmp.append(res);
                }
                res = new StringBuilder(stack_res.removeLast() + tmp);
            } else if (c >= '0' && c <= '9') {
                // 数字可能是2位或三位小数，后续遍历需要将原有数值*10倍
                multi = multi * 10 + Integer.parseInt(c + "");
            } else {
                // 其它直接拼接字符
                res.append(c);
            }
        }

        return res.toString();
    }
}