package solution;


import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 *
 * @author qinghua.shao
 * @date 2024/1/27
 * @since 1.0.0
 */
public class LC0022GenerateParentheses {

    private static List<String> ans = new ArrayList<>();

    public static List<String> generateParenthesis(int n) {
        dfs("", n, n);
        return ans;
    }

    // 关键思路：剩余左括号数要小于右括号数
    // left：剩余左括号数，right：剩余右括号数
    private static void dfs(String s, int left, int right) {
        if (left == 0 && right == 0) {
            ans.add(s);
            return;
        }

        // 剩余数量一样，下一个只能用左括号
        if (left == right) {
            dfs(s + "(", left - 1, right);
        } else if (left < right) {
            // 左括号数小于右括号数，下一个可以是左括号或右括号
            if (left > 0) {
                dfs(s + "(", left - 1, right);
            }
            dfs(s + ")", left, right - 1);
        }
    }

    public static void main(String[] args) {
        List<String> ans = generateParenthesis(2);
        System.out.println(ans);
    }
}