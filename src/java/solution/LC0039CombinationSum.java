package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 39. Combination Sum
 *
 * @author qinghua.shao
 * @date 2024/2/9
 * @since 1.0.0
 */
public class LC0039CombinationSum {

    // 结果
    private static List<List<Integer>> ans = new ArrayList<>();
    // 临时路径组合
    private static List<Integer> path = new ArrayList<>();

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, 0, target);
        return ans;
    }

    /**
     * candidates 候选数组
     * index 起点下标
     * target 目标值(每减去一个元素，目标值变小)
     */
    private static void dfs(int[] candidates, int index, int target) {

        // 由于进入更深层时，小于 0 的部分被剪枝，因此递归终止条件值只判断等于 0 的情况
        if (target == 0) {
            ans.add(new ArrayList(path));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            // 剪枝，前提是候选数组已经升序排列
            if (target < candidates[i]) {
                break;
            }
            path.add(candidates[i]);
            System.out.println("递归之前 => " + path + "，剩余 = " + (target - candidates[i]));
            // 注意：由于每一个元素可以重复使用，下一轮搜索的起点依然是 i，这里非常容易弄错
            dfs(candidates, i, target - candidates[i]);
            // 移除最后元素状态重置
            path.remove(path.size() - 1);
            System.out.println("递归之后 => " + path);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> ans = combinationSum(new int[]{2, 3, 6, 7}, 7);
        System.out.println("输出 => " + ans);
    }
}
