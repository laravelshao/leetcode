class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack();
        int i = 0;
        // 遍历 pushed 数组
        for (int num : pushed) {
            stack.push(num); // 元素入栈
            // 当栈不为空 且 栈顶元素等于弹出序列元素 popped[i]
            while (!stack.isEmpty() && (stack.peek() == popped[i])) { // 循环判断与出栈
                stack.pop();
                i++;
            }
        }

        return stack.isEmpty();
    }
}