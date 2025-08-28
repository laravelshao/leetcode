class Solution {
    public int longestValidParentheses(String s) {

        int ans = 0;
        // 栈存储左括号下标
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            // 左括号入栈
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                // 右括号出栈
                stack.pop();
                if (stack.isEmpty()) {
                    // 栈为空，说明当前右括号无对应左括号匹配(例：")()())")，将当前位置压入栈作为新起点
                    stack.push(i);
                } else {
                    ans = Math.max(ans, i - stack.peek());
                }
            }
        }
        return ans;
    }
}