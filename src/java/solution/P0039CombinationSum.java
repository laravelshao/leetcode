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
public class P0039CombinationSum {

    // 结果
    private static List<List<Integer>> ans = new ArrayList<>();
    // 临时组合
    private static List<Integer> tmpCombine = new ArrayList<>();

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, 0, target);
        return ans;
    }

    private static void dfs(int[] candidates, int index, int target) {
        if (target == 0) {
            ans.add(new ArrayList(tmpCombine));
            return;
        }

        if (index >= candidates.length || candidates[index] > target) {
            return;
        }

        dfs(candidates, index + 1, target);
        tmpCombine.add(candidates[index]);
        dfs(candidates, index, target - candidates[index]);
        tmpCombine.remove(tmpCombine.size() - 1);
    }

    public static void main(String[] args) {
        combinationSum(new int[]{2, 3, 6, 7}, 7);
    }
}
