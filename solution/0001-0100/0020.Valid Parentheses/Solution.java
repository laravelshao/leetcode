class Solution {
    public boolean isValid(String s) {
        // 字符串长度为奇数一定不是有效的
        if (s.length() % 2 == 1) {
            return false;
        }

        // 利用栈来实现
        Deque<Character> stack = new LinkedList<Character>();
        for (char ch : s.toCharArray()) {
            if(ch == '(' || ch == '{' || ch == '[') {
                // 碰到左边符号，压入栈
                stack.push(ch);
            } else if (stack.isEmpty() || !match(stack.pop(), ch)) {
                // 如果栈为空 或 栈弹出元素与当前元素不同，则无效
                return false;
            }
        }
        // 最终如果栈为空则有效
        return stack.isEmpty();
    }

    private boolean match(char l, char r) {
        return (l == '(' && r == ')') || (l == '{' && r == '}') || (l == '[' && r == ']');
    }
}