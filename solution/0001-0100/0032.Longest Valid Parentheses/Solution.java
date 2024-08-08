class Solution {
    public int longestValidParentheses(String s) {

        int ans = 0;
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
                    stack.push(i);
                } else {
                    ans = Math.max(ans, i - stack.peek());
                }
            }
        }
        return ans;
    }
}